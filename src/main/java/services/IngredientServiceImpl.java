package services;

import model.Ingredient;
import model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
@Service
public class IngredientServiceImpl {
    public int id = 0;
    private final Map<Integer, Ingredient> ingredientMap = new TreeMap<>();
    public void addIngredient(Ingredient ingredient){
        ingredientMap.put(id++ ,ingredient);

    }
    public Ingredient getIngredient(int id){
        return ingredientMap.get(id);
    }

    public Ingredient editIngredient (int id, Ingredient ingredient){
        ingredient.setTitle();
        return ingredientMap.get(id);

    }

    public boolean deleteIngredient(int id ){
        ingredientMap.remove(id);
        return true;
    }


}
