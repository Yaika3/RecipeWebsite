package me.max.recipewebsite.model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Recipe {

    private String title ;
    private int cookingTime;
    private ArrayList <Ingredient> ingredients;
    private ArrayList<String> cookingSteps;
    private int id = 0;


}
