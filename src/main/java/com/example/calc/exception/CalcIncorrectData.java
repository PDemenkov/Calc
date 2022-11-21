package com.example.calc.exception;

public class CalcIncorrectData {
    private String info;

    public CalcIncorrectData(String info) {
        this.info = info;
    }
    public CalcIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
