package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculate(double numberOne, double numberTwo, String operator) {
        String result = "";
        switch (operator) {
            case "Addition":
                result = String.valueOf(numberOne + numberTwo);
                break;
            case "Subtraction":
                result = String.valueOf(numberOne - numberTwo);
                break;
            case "Multiplication":
                result = String.valueOf(numberOne * numberTwo);
                break;
            case "Division":
                if (numberTwo == 0) {
                    result = "Can't Division for 0";
                } else
                    result = String.valueOf(numberOne / numberTwo);
                break;
        }
        return result;
    }
}
