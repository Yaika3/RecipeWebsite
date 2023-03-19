package me.max.recipewebsite.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.max.recipewebsite.model.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl {
    private final FileService fileService;
    private int id = 0;
    private Map<Integer, Ingredient> ingredientMap = new TreeMap<>();

    public IngredientServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientMap.put(id++, ingredient);
        saveToFIle();

    }

    public Ingredient getIngredient(int id) {
        return ingredientMap.get(id);
    }

    public ResponseEntity<Ingredient> editIngredient(int id, Ingredient ingredient) {
        if (ingredientMap.containsKey(id)) {
            ingredientMap.put(id, ingredient);
            return ResponseEntity.notFound().build();

        }
        saveToFIle();
        return null;

    }

    public boolean deleteIngredient(int id) {
        ingredientMap.remove(id);
        return true;
    }

    private void saveToFIle() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            fileService.saveToFileIngredient(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        String json = fileService.readFromFile();
        try {
            ingredientMap = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Integer, Ingredient>>() {
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
