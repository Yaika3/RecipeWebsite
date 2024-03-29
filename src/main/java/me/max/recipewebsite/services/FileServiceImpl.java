package me.max.recipewebsite.services;

import me.max.recipewebsite.model.Ingredient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service

public class FileServiceImpl implements FileService {
    @Value("${path.to.data.file}")
    private String dataFilePath;
    @Value("${name.of.data.file}")
    private String dataFileName;
    @Value("data.ingredient.json")
    private String dataFileNameIngredient;


    @Override
    public boolean saveToFileRecipe(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    @Override
    public boolean saveToFileRecipeTXT(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean saveToFileIngredient(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileNameIngredient), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(dataFilePath, dataFileName));
        } catch (IOException e) {
            return "{}";
        }
    }

    @Override
    public String readFromFileIngredient() {
        try {
            return Files.readString(Path.of(dataFilePath, dataFileNameIngredient));
        } catch (IOException e) {
            return "{}";
        }
    }

    @Override
    public boolean cleanDataFile() {
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public File getDataFile() {
        return new File(dataFilePath + "/" + dataFileName);
    }


    @Override
    public File getDataFileRecipe() {


        return new File(dataFilePath + "/" + dataFileName);
    }
    @Override
    public File getDataFileIngredient() {
        return new File(dataFilePath + "/" + dataFileNameIngredient);
    }

}
