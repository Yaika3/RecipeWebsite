package me.max.recipewebsite.services;

import java.io.File;

public interface FileService {
//    boolean saveToFile(String json);

    boolean saveToFileRecipe(String json);

    boolean saveToFileIngredient(String json);

    String readFromFile();

    String readFromFileIngredient();

    boolean cleanDataFile();

    File getDataFile();
}
