package com.devbrunorafael.springsecuritylogin.controllers;

import com.devbrunorafael.springsecuritylogin.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class HomeController {

    @GetMapping("/main")
    public Product main(){
        var pd = new Product();
        pd.setId(1L);
        pd.setName("produto 1");
        pd.setDescription("um produto");
        pd.setLocale("algum lugar da loja");
        pd.setQuantity(20);

        return pd;
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "acesso ao delete";
    }

    @PutMapping("/update")
    public String update(){
        return "acesso ao update";
    }

    @PostMapping("/create")
    public String create(){
        return "acesso ao create";
    }

}
