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

    @GetMapping("/symbolsCount")
    @ApiOperation(value = "Вычисляет частоту символов", notes = "Возвращает отображение символов и их частоты во входной строке в порядке убывания.")
    public Map<Character, Integer> calculateFrequency(@RequestParam String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        OperationsForSymbols operations = new OperationsForSymbols();


        return operations.sortByFrequencyDesc(frequencyMap);
    }

}
