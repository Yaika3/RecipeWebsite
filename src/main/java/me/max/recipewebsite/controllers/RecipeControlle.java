package me.max.recipewebsite.controllers;

import me.max.recipewebsite.model.Ingredient;
import me.max.recipewebsite.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import me.max.recipewebsite.services.RecipeServicesImpl;
@RequestMapping("/recipes")
@Controller
public class RecipeControlle {

    private final RecipeServicesImpl recipeServices;

    public RecipeControlle(RecipeServicesImpl recipeServices) {
        this.recipeServices = recipeServices;
    }

    @PostMapping("/{id}")
    public void addRecipe(@PathVariable int id, Recipe recipe) {
        recipeServices.addRecipe(recipe);

    }

    @GetMapping("/{id}")
    public Recipe getRecipe(int id) {
        return recipeServices.getRecipe(id);
    }

    @PutMapping("/{id}")
    public Ingredient editRecipe(int id, Recipe recipe) {
        return recipeServices.editRecipe(id, recipe).getBody();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        if (recipeServices.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
