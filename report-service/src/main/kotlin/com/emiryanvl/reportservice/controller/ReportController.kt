package com.emiryanvl.reportservice.controller

import com.emiryanvl.reportservice.config.MdcConfig.Companion.getReportTraceId
import com.emiryanvl.reportservice.config.ReportProperties
import com.emiryanvl.reportservice.service.CsvService
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/report")
class ReportController(val reportProperties: ReportProperties, val csvService: CsvService) {

    private val logger = LoggerFactory.getLogger(ReportController::class.java)

    @GetMapping   // Реализуйте ваш способ генерации уникального идентификатора
        // Например, можно использовать UUID
    fun getReport(): ResponseEntity<String> {
        val disks = RestTemplate().getForObject(reportProperties.reportUrl, String::class.java).toString()
        val response = csvService.uploadCsvFile(reportProperties.storageUrl, csvService.convertJsonToCsv(disks))
        logger.info("Report got with status code {}. TraceId: {}", response.statusCode, MDC.get(getReportTraceId()))
        return response
    }
}