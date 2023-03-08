package services;

import model.Ingredient;

import java.util.Map;
import java.util.TreeMap;

public class IngredientServiceImpl {
    public static int id = 0;
    private static Map<Integer, Ingredient> ingredientMap = new TreeMap<>();


    public static void addIngredient(Ingredient ingredient){
        ingredientMap.put(id++ , ingredient);

    }
    public void getIngredient(int id){
        ingredientMap.get(id);
    }
}
