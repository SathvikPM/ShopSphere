package com.ShopSphere.ShopSphere.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public  String getMessage(){
        return "Hii";
    }


}
