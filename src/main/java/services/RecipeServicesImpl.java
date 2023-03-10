package services;

import model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl {

    public int id = 0;
    private Map <Integer, Recipe> recipeMap = new TreeMap<>();

    public void addRecipe(Recipe recipe){
        recipeMap.put(id++ , recipe);

    }
    public Recipe getIngredient(int id){
         return recipeMap.get(id);
    }



}
