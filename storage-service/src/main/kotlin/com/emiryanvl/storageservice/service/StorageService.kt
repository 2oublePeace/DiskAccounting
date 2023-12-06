package com.emiryanvl.storageservice.service

import com.emiryanvl.storageservice.config.StorageProperties
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException

@Service
class StorageService(val storagePeoperties: StorageProperties) {

    init {
        val directory = File(storagePeoperties.uploadDirectory)
        if (!directory.exists()) {
            directory.mkdirs()
        }
    }

    fun saveDataFromCsv(file: MultipartFile) {
        try {
            val filePath = "${storagePeoperties.uploadDirectory}${file.originalFilename}"
            val destinationFile = File(filePath)

            file.transferTo(destinationFile)
        } catch (e: IOException) {
            e.printStackTrace()
            throw RuntimeException("Error saving data from CSV to file.")
        }
    }
}