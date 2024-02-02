package com.example.t1testtask;

import java.util.LinkedHashMap;
import java.util.Map;

public class OperatonsForSymbols {


    public Map<Character, Integer> sortByFrequencyDesc(Map<Character, Integer> frequencyMap) {
        // Сортировка по убыванию частоты
        return frequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
    }

}
