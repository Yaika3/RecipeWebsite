package services;

import model.Ingredient;
import model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl {

    public static int id = 0;
    private static Map <Integer, Recipe> recipeMap = new TreeMap<>();

    public static void addRecipe(Recipe recipe){
        recipeMap.put(id++ , recipe);

    }
    public void getIngredient(int id){
        recipeMap.get(id);
    }



}
