package com.devbrunorafael.springsecuritylogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(path = {"/login"})
    public String login(){
        return "login";
    }

    @RequestMapping(path = {"/"})
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }
}
