package com.example.calc.CalcService;

import com.example.calc.exception.IllegalNumberException;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int plus(int num1, int num2) {
        return num1+num2;
    }

    public int minus(int num1, int num2) {
      return   num1 - num2;
    }

    public int miultiply(int num1, int num2) {
        return num1*num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
        throw new IllegalNumberException("Деление на 0");
        }
        return num1/num2;
    }
}
