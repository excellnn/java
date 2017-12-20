package com.example.demo.spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(IOException.class)
    public String handler(){
        return "error";
    }
}
