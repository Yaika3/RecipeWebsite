package me.max.recipewebsite.controllers;

import model.Ingredient;
import model.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import services.RecipeServicesImpl;

@Controller
public class RecipeControlle {

    private RecipeServicesImpl recipeServices;

    public RecipeControlle(RecipeServicesImpl recipeServices) {
        this.recipeServices = recipeServices;
    }

    @PostMapping("/addRecipe")
    public void addRecipe(Recipe recipe){
        recipeServices.addRecipe(recipe);

    }@GetMapping("/getRecipe")
    public Recipe getIngredient(int id){
        return recipeServices.getIngredient(id);
    }
}
