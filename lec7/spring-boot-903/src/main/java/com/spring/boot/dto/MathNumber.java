package com.spring.boot.dto;

public class MathNumber<T extends Number> {

    private T num1;
    private T num2;

    public MathNumber(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public void setNum2(T num2) {
        this.num2 = num2;
    }


    public Double sum() {
        return num1.doubleValue() + num2.doubleValue();
    }

    public Double diff() {
        return num1.doubleValue() * num2.doubleValue();
    }

}
