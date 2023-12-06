package com.emiryanvl.reportservice.controller

import com.emiryanvl.reportservice.config.ReportProperties
import com.emiryanvl.reportservice.service.CsvService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/report")
class ReportController(val reportProperties: ReportProperties, val csvService: CsvService) {
    @GetMapping
    fun getReport(): ResponseEntity<String> {
        val disks = RestTemplate().getForObject(reportProperties.reportUrl, String::class.java).toString()
        return csvService.uploadCsvFile(reportProperties.storageUrl, csvService.convertJsonToCsv(disks))
    }
}