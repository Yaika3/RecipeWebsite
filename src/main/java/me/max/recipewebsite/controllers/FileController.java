package me.max.recipewebsite.controllers;

import io.swagger.v3.oas.annotations.Operation;
import me.max.recipewebsite.services.FileService;
import me.max.recipewebsite.services.RecipeServicesImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;
    private RecipeServicesImpl recipeServices;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/export")
    @Operation(description =  " Метод для скачивания рецепта ")
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
        File file = fileService.getDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipe.json \"").contentLength(file.length()).body(resource);

        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping(value = "/exportTEXT")
    @Operation(description =  " Метод для скачивания рецепта в виде текста ")
    public ResponseEntity<InputStreamResource> downloadDataFileText() throws FileNotFoundException {
        File dowFile = fileService.getDataFile();
        if (dowFile.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(dowFile));
            return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName =\"Recipe.text \"").contentLength(dowFile.length()).body(resource);

        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @PutMapping(value = "/importRecipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataFileRecipe(@RequestParam MultipartFile file) {
        fileService.cleanDataFile();
        File dataFile = fileService.getDataFileRecipe();
        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();

        } return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
    @PutMapping(value = "/importIngredient", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataFileIngredient(@RequestParam MultipartFile file) {
        fileService.cleanDataFile();
        File dataFile = fileService.getDataFileIngredient();
        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            recipeServices.saveToFIle();
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();

        } return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }



    }
//коммент для пул

