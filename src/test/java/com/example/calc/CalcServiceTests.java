package com.example.calc;

import com.example.calc.CalcService.CalcService;
import com.example.calc.exception.IllegalNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalcServiceTests {
    private final CalcService calcService = new CalcService();


    @ParameterizedTest
    @MethodSource("plusParams")
    public void plusParamTest(int num1, int num2, int result) {
        assertEquals(result,calcService.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    public void minusParamTest(int num1, int num2, int result) {
        assertEquals(result,calcService.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    public void multiplyParamTest(int num1, int num2, int result) {
        assertEquals(result,calcService.miultiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("divideParams")
    public void divideParamTest(int num1, int num2, int result) {
        assertEquals(result,calcService.divide(num1, num2));
    }

    public static List<Arguments> plusParams() {
        return List.of(
                Arguments.of(5, 5, 10),
                Arguments.of(1, 3, 4),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> minusParams() {
        return List.of(
                Arguments.of(5, 5, 0),
                Arguments.of(1, 3, -2),
                Arguments.of(-5, -3, -2)
        );
    }

    public static List<Arguments> multiplyParams() {
        return List.of(
                Arguments.of(5, 5, 25),
                Arguments.of(1, 3, 3),
                Arguments.of(-5, -3, 15)
        );
    }

    public static List<Arguments> divideParams() {
        return List.of(
                Arguments.of(5, 5, 1),
                Arguments.of(2, 2, 1),
                Arguments.of(-6, -3,2)
        );
    }

    @Test
    void testPlus() {
        assertEquals(20, calcService.plus(10, 10));
        assertEquals(13, calcService.plus(3, 10));
        assertEquals(11, calcService.plus(1, 10));
        assertEquals(10, calcService.plus(0, 10));
    }

    @Test
    void testMinus() {
        assertEquals(0, calcService.minus(10, 10));
        assertEquals(-7, calcService.minus(3, 10));
        assertEquals(-9, calcService.minus(1, 10));
        assertEquals(-10, calcService.minus(0, 10));
    }

    @Test
    void testMiultiply() {
        assertEquals(100, calcService.miultiply(10, 10));
        assertEquals(30, calcService.miultiply(3, 10));
        assertEquals(10, calcService.miultiply(1, 10));
        assertEquals(0, calcService.miultiply(0, 10));
    }

    @Test
    void testDivide() {
        assertEquals(1, calcService.divide(10, 10));
        assertEquals(0, calcService.divide(3, 10));
        assertEquals(0, calcService.divide(1, 10));
        assertEquals(0, calcService.divide(0, 10));
    }

    @Test
    void divideByZero() {
        assertThrows(IllegalNumberException.class, () -> calcService.divide(10, 0));

    }
}
