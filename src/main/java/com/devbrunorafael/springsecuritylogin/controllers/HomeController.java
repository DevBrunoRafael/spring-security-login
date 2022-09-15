package com.devbrunorafael.springsecuritylogin.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class HomeController {

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/get")
    public String get(){
        return "acesso ao get";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/getAll")
    public String getAll(){
        return "acesso ao getAll";
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/create")
    public String create(){
        return "acesso ao create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public String update(){
        return "acesso ao update";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public String delete(){
        return "acesso ao delete";
    }

}
