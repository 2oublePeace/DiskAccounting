package com.emiryanvl.reportservice.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/report")
class ReportController() {
    @GetMapping
    fun getReport(): String? = RestTemplate().getForObject("http://localhost:8081/disk", String::class.java)
}