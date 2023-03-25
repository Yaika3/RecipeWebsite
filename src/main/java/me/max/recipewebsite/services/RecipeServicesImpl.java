package me.max.recipewebsite.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.max.recipewebsite.model.Ingredient;
import me.max.recipewebsite.model.Recipe;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServicesImpl {
    private final FileService fileService;
    private int id = 0;
    private Map<Integer, Recipe> recipeMap = new TreeMap<>();

    public RecipeServicesImpl(FileService fileService) {
        this.fileService = fileService;

    }

    public void addRecipe(Recipe recipe) {
        recipeMap.put(id ++,recipe);
        saveToFIle();



    }

    public Recipe getRecipe(int id) {
        return recipeMap.get(id);
    }

    public ResponseEntity<Ingredient> editRecipe(int id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, recipe);
            return ResponseEntity.notFound().build();

        }saveToFIle();
        return null;

    }

    public boolean deleteRecipe(int id) {
        recipeMap.remove(id);
        return true;
    }
    private void saveToFIle() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            fileService.saveToFileRecipe(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readFromFile() {
        String json = fileService.readFromFile();
        try {
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @PostConstruct
    private void init() {
        readFromFile();
    }


}




