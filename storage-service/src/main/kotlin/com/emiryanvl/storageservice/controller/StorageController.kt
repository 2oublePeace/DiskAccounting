package com.emiryanvl.storageservice.controller

import com.emiryanvl.storageservice.service.StorageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/storage")
class StorageController(val storageService: StorageService) {
    @PostMapping("/upload")
    fun handleFileUpload(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        return try {
            storageService.saveDataFromCsv(file)
            ResponseEntity.ok().body("File uploaded successfully.")
        } catch (e: Exception) {
            ResponseEntity.status(500).body("Error uploading the file.")
        }
    }
}