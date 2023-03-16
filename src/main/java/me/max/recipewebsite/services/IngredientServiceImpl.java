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

    public void addIngredient(Ingredient ingredient) {
        ingredientMap.put(id++, ingredient);

    }

    public Ingredient getIngredient(int id) {
        return ingredientMap.get(id);
    }

    public ResponseEntity<Ingredient> editIngredient(int id, Ingredient ingredient) {
        if (ingredientMap.containsKey(id)) {
           ingredientMap.put(id, ingredient);
            return ResponseEntity.notFound().build();

        }
        return null;

    }

    public boolean deleteIngredient(int id) {
        ingredientMap.remove(id);
        return true;
    }


}
