package me.max.recipewebsite.services;

import io.swagger.v3.oas.annotations.Operation;
import me.max.recipewebsite.model.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl {
    public int id = 0;
    private final Map<Integer, Ingredient> ingredientMap = new TreeMap<>();

    @Operation(description = "Добавление ингредиента ")
    public void addIngredient(Ingredient ingredient) {
        ingredientMap.put(id++, ingredient);

    }

    @Operation(description = "Получение ингредиента по id")
    public Ingredient getIngredient(int id) {
        return ingredientMap.get(id);
    }

    @Operation(description = "Изменение ингредиента по id")
    public ResponseEntity<Ingredient> editIngredient(int id, Ingredient ingredient) {
        Ingredient ingredient1 = ingredientMap.get(id);
        if (ingredient1 == null) {
            ingredient1.setTitleIngredient(new Ingredient().getTitleIngredient());
            return ResponseEntity.notFound().build();

        }
        return null;

    }

    @Operation(description = "Удаление ингредиента по id")
    public boolean deleteIngredient(int id) {
        ingredientMap.remove(id);
        return true;
    }


}
