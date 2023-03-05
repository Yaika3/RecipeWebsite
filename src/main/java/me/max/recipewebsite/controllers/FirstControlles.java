package me.max.recipewebsite.controllers;

import model.Ingredient;
import model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.RecipeServicesImpl;

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
    @GetMapping("/addIngredient")
    public void addIngredient(@RequestParam Ingredient ingredient ){
        RecipeServicesImpl.addIngredient(ingredient);
    }
    @GetMapping("/addIngredient")
    public void addRecipe(@RequestParam Recipe recipe){
        RecipeServicesImpl.addRecipe(recipe);
    }


}
