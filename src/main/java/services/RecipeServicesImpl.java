package services;

import model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl {

    public int id = 0;
    private final Map <Integer, Recipe> recipeMap = new TreeMap<>();

    public void addRecipe(Recipe recipe){
        recipeMap.put(id++ , recipe);

    }
    public Recipe getRecipe(int id){
         return recipeMap.get(id);
    }
    public Recipe editRecipe (int id, Recipe recipe){
        recipe.setTitle();
        return recipeMap.get(id);

    }

    public boolean deleteRecipe(int id ){
                recipeMap.remove(id);
        return true;
    }


    }




