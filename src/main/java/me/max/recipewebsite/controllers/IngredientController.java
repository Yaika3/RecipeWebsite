package me.max.recipewebsite.controllers;

import model.Ingredient;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class IngredientController {
    public int id = 0;
    private Map<Integer, Ingredient> ingredientMap = new TreeMap<>();

    public void addIngredient(Ingredient ingredient){
        ingredientMap.put(id++ , ingredient);

    }
    public Ingredient getIngredient(int id){
        return ingredientMap.get(id);
    }
}
