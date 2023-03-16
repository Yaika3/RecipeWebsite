package me.max.recipewebsite.services;

import io.swagger.v3.oas.annotations.Operation;
import me.max.recipewebsite.model.Ingredient;
import me.max.recipewebsite.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl {

    public int id = 0;
    private final Map<Integer, Recipe> recipeMap = new TreeMap<>();

    public void addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);

    }

    public Recipe getRecipe(int id) {
        return recipeMap.get(id);
    }

    public ResponseEntity<Ingredient> editRecipe(int id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, recipe);
            return ResponseEntity.notFound().build();

        }
        return null;

    }

    public boolean deleteRecipe(int id) {
        recipeMap.remove(id);
        return true;
    }


}




