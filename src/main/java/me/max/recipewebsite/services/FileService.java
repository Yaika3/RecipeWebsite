package me.max.recipewebsite.services;

public interface FileService {
    boolean saveToFile(String json);

    String readFromFile();

}