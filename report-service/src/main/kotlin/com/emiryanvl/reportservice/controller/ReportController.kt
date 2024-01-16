package com.emiryanvl.reportservice.controller

import com.emiryanvl.reportservice.config.ReportProperties
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/report")
class ReportController(val reportProperties: ReportProperties, val streamBridge: StreamBridge) {
    @GetMapping
    fun getReport(): ResponseEntity<String> {
        val disks = RestTemplate().getForObject(reportProperties.reportUrl, String::class.java).toString()
        streamBridge.send("saveDisks-out-0", disks)
        return ResponseEntity.ok("File uploaded successfully.")
    }
}