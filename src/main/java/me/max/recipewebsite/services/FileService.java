package me.max.recipewebsite.services;

import java.io.File;
import java.nio.file.Path;

public interface FileService {
//    boolean saveToFile(String json);

    boolean saveToFileRecipe(String json);

    boolean saveToFileRecipeTXT(String json);

    boolean saveToFileIngredient(String json);

    String readFromFile();

    String readFromFileIngredient();

    boolean cleanDataFile();

    File getDataFile();

    File getDataFileRecipe();

    File getDataFileIngredient();
}
