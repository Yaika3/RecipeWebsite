package me.max.recipewebsite.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstControlles {

    @GetMapping
    public String Hallo() {
        return " Hallo ";
    }
}
