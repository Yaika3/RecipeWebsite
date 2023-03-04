package me.max.recipewebsite.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstControlles {

    @GetMapping("/")
    public String projectDescription() {
        return " Название проэкта = Сайт рецептов , функции проекта - ,\n" +
                "с помощью каких технологий будет реализован проект - ,\n" +
                "на каком языке проект написан - Java " +
                "Приложение запущено ";
    }
    @GetMapping("/studentsname")
    public String studentsName(){
        return "Максим Яковлев ";
    }
    @GetMapping("/projectname")
    public String projectname(){
        return "сайт рецептов ";
    }
    @GetMapping("/projectcreationdate")
    public String projectCreationDate(){
        return "03.03.2023 ";
    }
    @GetMapping("/description")
    public String description(){
        return "готовим всегда)) ";
    }
}
