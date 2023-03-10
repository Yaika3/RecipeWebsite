package services;

import model.Ingredient;
import model.Recipe;

import java.util.Map;
import java.util.TreeMap;

public class IngredientServiceImpl {
    public int id = 0;
    private Map<Integer, Ingredient> ingredientMap = new TreeMap<>();
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
