package com.emiryanvl.storageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.IOException;

public interface CsvService {
    File convertJsonToCsv(String jsonString) throws IOException;
}
