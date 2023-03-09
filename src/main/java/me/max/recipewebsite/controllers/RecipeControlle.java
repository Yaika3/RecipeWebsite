package me.max.recipewebsite.controllers;

import model.Ingredient;
import model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import services.RecipeServicesImpl;

@Controller
public class RecipeControlle {

    private RecipeServicesImpl recipeServices;

    public RecipeControlle(RecipeServicesImpl recipeServices) {
        this.recipeServices = recipeServices;
    }

    @GetMapping("/addRecipe")
    public void addRecipe(Recipe recipe){
        recipeMap.put(id++ , recipe);

    }
    public Recipe getIngredient(int id){
        return recipeMap.get(id);
    }
}
