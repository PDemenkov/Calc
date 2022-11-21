package com.example.calc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalcGlobalExceptionHandler {

    @ExceptionHandler // деление на 0
    public ResponseEntity<CalcIncorrectData> handleException(
            IllegalNumberException exception) {
        CalcIncorrectData data = new CalcIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler // обработка глобальных исключений
    public ResponseEntity<CalcIncorrectData> handleException(
            Exception exception) {
        CalcIncorrectData data = new CalcIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.EXPECTATION_FAILED);
    }
}
