package me.max.recipewebsite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String titleIngredient;
    private int quantity;
    private String unitOfMeasurement;
}
