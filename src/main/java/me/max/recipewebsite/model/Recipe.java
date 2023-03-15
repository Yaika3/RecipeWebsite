package me.max.recipewebsite.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Recipe {
    private String title;
    private int cookingTime;
    private ArrayList <Ingredient> ingredients;
    private ArrayList<String> cookingSteps;

}
