package com.example.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //localhost:8080에 들어가면 바로 호출됨
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
