package com.example.calc.Controller;

import com.example.calc.CalcService.CalcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/")
    public String greetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String getSum(@RequestParam(value = "num1") int num1,
                         @RequestParam(value = "num2") int num2) {
        int result = calcService.plus(num1,num2);
        return String.format("%d + %d = %d",num1,num2,result);
    }

    @GetMapping("/minus")
    public String getMinus(@RequestParam(value = "num1") int num1,
                           @RequestParam(value = "num2") int num2) {
        int result = calcService.minus(num1,num2);
        return String.format("%d - %d = %d",num1,num2,result);    }

    @GetMapping("/multiply")
    public String getMultiply(@RequestParam(value = "num1") int num1,
                              @RequestParam(value = "num2") int num2) {
        int result = calcService.miultiply(num1,num2);
        return String.format("%d * %d = %d",num1,num2,result);
    }

    @GetMapping("/divide")
    public String getDivide (@RequestParam(value = "num1") int num1,
                             @RequestParam(value = "num2") int num2) {
        int result = calcService.divide(num1,num2);
        return String.format("%d / %d = %d",num1,num2,result);
    }
}
