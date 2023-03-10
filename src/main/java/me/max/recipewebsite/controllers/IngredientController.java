package me.max.recipewebsite.controllers;

import model.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import services.IngredientServiceImpl;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class IngredientController {
    private IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }


    @PostMapping ("/addIngredient")
    public void addIngredient(Ingredient ingredient){
        ingredientService.addIngredient(ingredient);

    }@GetMapping("/getIngredient")
    public Ingredient getIngredient(int id){

        return ingredientService.getIngredient(id);
    }
}
