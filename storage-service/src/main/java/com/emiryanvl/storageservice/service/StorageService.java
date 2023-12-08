package com.emiryanvl.storageservice.service;

import java.io.InputStream;

public interface StorageService {
    void saveFile(String bucketName, String objectName, InputStream inputStream);
}
