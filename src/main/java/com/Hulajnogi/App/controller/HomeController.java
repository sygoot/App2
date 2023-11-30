package com.Hulajnogi.App.controller;

import com.Hulajnogi.App.model.Vehicle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping 
    public String hello() {
        return "Welcome to the Main Page!";
    }

}