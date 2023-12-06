package com.emiryanvl.storageservice.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class StorageProperties {
    @Value("\${upload-directory}")
    lateinit var uploadDirectory: String
}