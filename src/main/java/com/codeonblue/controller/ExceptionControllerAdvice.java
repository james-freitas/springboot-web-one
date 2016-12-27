package com.codeonblue.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String exception(RuntimeException exception, Model model){
        model.addAttribute("exception", exception);
        return "error/errorHandler";
    }
}
