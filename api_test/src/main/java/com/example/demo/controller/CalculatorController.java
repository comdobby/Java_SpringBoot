package com.example.demo.controller;

import com.example.demo.dto.CalculatorDivRequest;
import com.example.demo.dto.CalculatorSubRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/sub")
    public int subTwoNumbers(CalculatorSubRequest request) {
        return request.getNumber1() - request.getNumber2();
    }

    @PostMapping("/div")
    public int divTwoNumbers(@RequestBody CalculatorDivRequest request) {
        return (int)(request.getNumber1() / request.getNumber2());
    }
}
