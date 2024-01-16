package com.emiryanvl.storageservice;

import com.emiryanvl.storageservice.service.CsvService;
import com.emiryanvl.storageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.function.Consumer;

@SpringBootApplication
public class StorageServiceApplication {

    @Autowired
    StorageService storageService;

    @Autowired
    CsvService csvService;

    public static void main(String[] args) {
        SpringApplication.run(StorageServiceApplication.class, args);
    }

    @Bean
    Consumer<String> saveDisks() {
        return str -> {
            try {
                File file = csvService.convertJsonToCsv(str);
                InputStream inputStream = new FileInputStream(file);
                storageService.saveFile("bucket", file.getName(), inputStream);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
