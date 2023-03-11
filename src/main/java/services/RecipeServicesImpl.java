package services;

import io.swagger.v3.oas.annotations.Operation;
import model.Ingredient;
import model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl {

    public int id = 0;
    private final Map<Integer, Recipe> recipeMap = new TreeMap<>();

    @Operation(description = "Добавление рецепта ")
    public void addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);

    }

    @Operation(description = "Получение рецепта по id")
    public Recipe getRecipe(int id) {
        return recipeMap.get(id);
    }

    @Operation(description = "Изменение рецепта по id")
    public ResponseEntity<Ingredient> editRecipe(int id, Recipe recipe) {
        Recipe recipe1 = recipeMap.get(id);
        if (recipe1 == null) {
            recipe1.setTitle(new Recipe().getTitle());
            return ResponseEntity.notFound().build();

        }
        return null;

    }

    @Operation(description = "Удаление рецепта по id")
    public boolean deleteRecipe(int id) {
        recipeMap.remove(id);
        return true;
    }


}




