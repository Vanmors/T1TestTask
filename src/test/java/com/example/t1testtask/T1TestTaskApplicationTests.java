package com.example.t1testtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class T1TestTaskApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCalculateFrequency() {
        String input = "aaaaabcccc";
        Map<Character, Integer> result = restTemplate.getForObject("http://localhost:" + port + "/symbolsCount?input=" + input, Map.class);

        assertEquals(5, result.get("a"));
        assertEquals(4, result.get("c"));
        assertEquals(1, result.get("b"));

    }

    @Test
    void testCalculateFrequency1() {
        String input = "";
        Map<Character, Integer> result = restTemplate.getForObject("http://localhost:" + port + "/symbolsCount?input=" + input, Map.class);

        assertEquals(0, result.size());
    }


    @Test
    void sortByFrequencyDesc_SortedCorrectly() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put('a', 3);
        frequencyMap.put('b', 5);
        frequencyMap.put('c', 1);

        OperationsForSymbols operations = new OperationsForSymbols();

        Map<Character, Integer> result = operations.sortByFrequencyDesc(frequencyMap);

        assertThat(result).containsExactlyEntriesOf(
                new LinkedHashMap<>() {{
                    put('b', 5);
                    put('a', 3);
                    put('c', 1);
                }}
        );
    }

    @Test
    void sortByFrequencyDesc_EmptyMap_ReturnsEmptyMap() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        OperationsForSymbols operations = new OperationsForSymbols();

        Map<Character, Integer> result = operations.sortByFrequencyDesc(frequencyMap);

        assertThat(result).isEmpty();
    }

    @Test
    void sortByFrequencyDesc_SingleEntry_ReturnsSameMap() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put('a', 3);
        OperationsForSymbols operations = new OperationsForSymbols();

        Map<Character, Integer> result = operations.sortByFrequencyDesc(frequencyMap);

        assertThat(result).containsExactlyEntriesOf(frequencyMap);
    }

}
