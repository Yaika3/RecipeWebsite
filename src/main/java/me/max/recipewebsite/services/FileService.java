package me.max.recipewebsite.services;

public interface FileService {
//    boolean saveToFile(String json);

    boolean saveToFileRecipe(String json);

    boolean saveToFileIngredient(String json);

    String readFromFile();

}
