package com.densoft.springdemoaop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneService {
    public String getFortune(boolean tripWire){

        if(tripWire){
            throw new RuntimeException("something went wrong!");
        }
        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "you are lucky";
    }
}
