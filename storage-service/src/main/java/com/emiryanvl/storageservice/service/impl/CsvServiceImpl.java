package com.emiryanvl.storageservice.service.impl;

import com.emiryanvl.storageservice.service.CsvService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {
    @Override
    public File convertJsonToCsv(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, Object>> disks = objectMapper.readValue(jsonString, List.class);

        File csvFile = File.createTempFile("disk-report", ".csv");
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFile))) {
            String[] headerRecord = {"Title", "Is rented"};
            csvWriter.writeNext(headerRecord);

            for (var disk : disks) {
                String[] record = { disk.get("title").toString(), disk.get("isRented").toString() };
                csvWriter.writeNext(record);
            }
        }

        return csvFile;
    }
}
