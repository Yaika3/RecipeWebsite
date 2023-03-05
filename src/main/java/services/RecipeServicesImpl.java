package services;

import model.Ingredient;
import model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl {

    public static int id = 0;
    private static Map <Integer, Ingredient> ingredientMap = new TreeMap<>();
    private static Map <Integer, Recipe> recipeMap = new TreeMap<>();


    public static void addIngredient(Ingredient ingredient){
    ingredientMap.put(id++ , ingredient);

    }
    public static void addRecipe(Recipe recipe){
        recipeMap.put(id++ , recipe);

    }
    public void getIngredient(){}



}
