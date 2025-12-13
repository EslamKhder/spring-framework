package com.spring.boot.resturantbackend;

public class IdException extends Exception{

    private String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
