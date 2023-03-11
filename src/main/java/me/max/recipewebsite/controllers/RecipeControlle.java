package me.max.recipewebsite.controllers;

import model.Ingredient;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.RecipeServicesImpl;

@Controller
public class RecipeControlle {

    private final RecipeServicesImpl recipeServices;

    public RecipeControlle(RecipeServicesImpl recipeServices) {
        this.recipeServices = recipeServices;
    }

    @PostMapping("/{id}")
    public void addRecipe(@PathVariable int id, Recipe recipe){
        recipeServices.addRecipe(recipe);

    }@GetMapping("/{id}")
    public Recipe getRecipe(int id){
        return recipeServices.getRecipe(id);
    }
//
//    @PutMapping("/{id}")
//    public Recipe


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id){
        if (recipeServices.deleteRecipe(id)){
            return ResponseEntity.ok().build();
        }return ResponseEntity.notFound().build();

    }
}
