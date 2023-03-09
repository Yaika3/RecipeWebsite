package me.max.recipewebsite.controllers;

import model.Ingredient;

public class RecipeControlle {

    public void addIngredient(Ingredient ingredient){
        ingredientMap.put(id++ , ingredient);

    }
    public void getIngredient(int id){
       return ingredientMap.get(id);
    }
}
