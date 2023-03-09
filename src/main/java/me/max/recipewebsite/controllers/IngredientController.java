package me.max.recipewebsite.controllers;

import model.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import services.IngredientServiceImpl;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class IngredientController {
    private IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    public int id = 0;
    private Map<Integer, Ingredient> ingredientMap = new TreeMap<>();
    @GetMapping("/addIngredient")
    public void addIngredient(Ingredient ingredient){
        ingredientMap.put(id++ , ingredient);

    }
    public Ingredient getIngredient(int id){
        return ingredientMap.get(id);
    }
}
