package com.example.t1testtask;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OperationsForSymbolsTests {

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
