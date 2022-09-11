package com.devbrunorafael.springsecuritylogin.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

}