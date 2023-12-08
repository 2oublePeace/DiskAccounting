package com.emiryanvl.storageservice.controller;

import com.emiryanvl.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage")
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file)
    {
        try {
            storageService.saveFile("bucket", file.getName().toString(), file.getInputStream());
            return ResponseEntity.ok().body("File uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading the file.");
        }
    }

}