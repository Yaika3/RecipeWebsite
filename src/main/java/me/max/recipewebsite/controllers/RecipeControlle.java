package me.max.recipewebsite.controllers;

import io.swagger.v3.oas.annotations.Operation;
import me.max.recipewebsite.model.Ingredient;
import me.max.recipewebsite.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.max.recipewebsite.services.RecipeServicesImpl;

@RequestMapping("/recipes")
@RestController
public class RecipeControlle {

    private final RecipeServicesImpl recipeServices;

    public RecipeControlle(RecipeServicesImpl recipeServices) {
        this.recipeServices = recipeServices;
    }

    @Operation(description = "Добавление рецепта ")
    @PostMapping("/addRecipe/1")
    public void addRecipe(@RequestBody Recipe recipe) {
        recipeServices.addRecipe(recipe);

    }

    @Operation(description = "Получение рецепта по id")
    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        return recipeServices.getRecipe(id);
    }

    @Operation(description = "Изменение рецепта по id")
    @PutMapping("/{id}")
    public Ingredient editRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeServices.editRecipe(id, recipe).getBody();
    }

    @Operation(description = "Удаление рецепта по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        if (recipeServices.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
