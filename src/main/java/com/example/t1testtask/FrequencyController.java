package com.example.t1testtask;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "Frequency API", description = "Операции для вычисления частоты символов")
public class FrequencyController {

    @GetMapping("/calculateFrequency")
    @ApiOperation(value = "Calculate character frequency", notes = "Возвращает отображение символов и их частоты во входной строке в порядке убывания.")
    public Map<Character, Integer> calculateFrequency(@RequestParam String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        OperatonsForSymbols operatons = new OperatonsForSymbols();


        return operatons.sortByFrequencyDesc(frequencyMap);
    }

//    private Map<Character, Integer> sortByFrequencyDesc(Map<Character, Integer> frequencyMap) {
//        // Сортировка по убыванию частоты
//        return frequencyMap.entrySet()
//                .stream()
//                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
//                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
//    }

}
