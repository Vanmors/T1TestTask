package com.example.t1testtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FrequencyControllerTests {
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
    void testCalculateFrequencyEmptyRequest() {
        String input = "";
        Map<Character, Integer> result = restTemplate.getForObject("http://localhost:" + port + "/symbolsCount?input=" + input, Map.class);

        assertEquals(0, result.size());
    }

}
