package com.spring.restaurant.util;

import com.spring.restaurant.model.clientmodels.Client;
import com.spring.restaurant.service.OrderService;

import java.util.UUID;

public class UserCode {

    public static String extractCode(){
        return UUID.randomUUID().toString();
    }


    public static String generateCode(Integer count, String userName){
        return userName + " - " + count;
    }
}
