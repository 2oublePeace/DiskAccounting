package com.emiryanvl.storageservice.service.impl;

import com.emiryanvl.storageservice.service.StorageService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class MinioServiceImpl implements StorageService {
    private final MinioClient minioClient;

    public MinioServiceImpl(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public void saveFile(String bucketName, String objectName, InputStream inputStream) {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .stream(inputStream, inputStream.available(), -1)
                            .build()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
