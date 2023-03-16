package me.max.recipewebsite.controllers;

import io.swagger.v3.oas.annotations.Operation;
import me.max.recipewebsite.model.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.max.recipewebsite.services.IngredientServiceImpl;
@RequestMapping("/ingredients")
@RestController
public class IngredientController {
    private final IngredientServiceImpl ingredientService;

    public IngredientController(IngredientServiceImpl ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(description = "Добавление ингредиента ")
    @PostMapping("/addIngredient")
    public void addIngredient(Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);

    }
    @Operation(description = "Получение ингредиента по id")
    @GetMapping("/getIngredient")
    public Ingredient getIngredient(int id) {

        return ingredientService.getIngredient(id);
    }
    @Operation(description = "Изменение ингредиента по id")
    @PutMapping("/{id}")
    public Ingredient editIngredient(int id, Ingredient ingredient) {
        return ingredientService.editIngredient(id, ingredient).getBody();
    }

    @Operation(description = "Удаление ингредиента по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}
