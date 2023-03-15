package me.max.recipewebsite.model;

import lombok.Data;

@Data
public class Ingredient {
    private String titleIngredient;
    private int quantity;
    private String unitOfMeasurement;
}
