package com.example.t1testtask;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Api(tags = "Frequency API", description = "Operations for calculating character frequency")
public class FrequencyController {

    @GetMapping("/calculateFrequency")
    @ApiOperation(value = "Calculate character frequency", notes = "Returns a map of characters and their frequency in the input string.")
    public Map<Character, Integer> calculateFrequency(@RequestParam String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        return sortByFrequencyDesc(frequencyMap);
    }

    private Map<Character, Integer> sortByFrequencyDesc(Map<Character, Integer> frequencyMap) {
        // Сортировка по убыванию частоты
        return frequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
    }

}
