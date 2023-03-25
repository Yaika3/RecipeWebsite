package me.max.recipewebsite.controllers;

import me.max.recipewebsite.services.FileService;
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

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/export", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputStreamResource> dowloadDataFile() throws FileNotFoundException {
        File file = fileService.getDataFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipe.json \"").contentLength(file.length()).body(resource);

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
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();

        } return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }



    }


