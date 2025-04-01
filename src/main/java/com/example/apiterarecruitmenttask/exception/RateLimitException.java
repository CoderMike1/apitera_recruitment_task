package com.example.apiterarecruitmenttask.exception;

public class RateLimitException extends RuntimeException{
    public RateLimitException(String message){
        super(message);
    }

}
