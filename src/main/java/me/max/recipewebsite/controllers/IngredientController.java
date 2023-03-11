package me.max.recipewebsite.controllers;

import model.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.IngredientServiceImpl;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class IngredientController {
    private final IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }


    @PostMapping("/addIngredient")
    public void addIngredient(Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);

    }

    @GetMapping("/getIngredient")
    public Ingredient getIngredient(int id) {

        return ingredientService.getIngredient(id);
    }

    @PutMapping("/{id}")
    public Ingredient editIngredient(int id, Ingredient ingredient) {
        return ingredientService.editIngredient(id, ingredient).getBody();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
