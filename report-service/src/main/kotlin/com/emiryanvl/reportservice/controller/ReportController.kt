package com.emiryanvl.reportservice.controller

import com.emiryanvl.mainservice.dto.response.DiskResponse
import com.emiryanvl.mainservice.service.DiskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ReportController(val diskService: DiskService) {
    @GetMapping("/report")
    fun getReport() : ResponseEntity<List<DiskResponse>> {
        return ResponseEntity<List<DiskResponse>>(diskService.getAll(), HttpStatus.OK)
    }
}