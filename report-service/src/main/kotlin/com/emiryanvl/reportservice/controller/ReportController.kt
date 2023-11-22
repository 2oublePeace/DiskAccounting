package com.emiryanvl.reportservice.controller

import com.emiryanvl.reportservice.config.ReportProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/report")
class ReportController(val reportProperties: ReportProperties) {
    @GetMapping
    fun getReport(): String? = RestTemplate().getForObject(reportProperties.reportUrl, String::class.java)
}