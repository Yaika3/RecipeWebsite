package me.max.recipewebsite.controllers;

import model.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import services.IngredientServiceImpl;

import java.util.Map;
import java.util.TreeMap;

@Controller
public class IngredientController {
    private final IngredientServiceImpl ingredientService;

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
    //
//    @PutMapping("/{id}")
//    public Ingredient


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient (@PathVariable int id){
        if (ingredientService.deleteIngredient(id)){
            return ResponseEntity.ok().build();
        }return ResponseEntity.notFound().build();

    }
}
