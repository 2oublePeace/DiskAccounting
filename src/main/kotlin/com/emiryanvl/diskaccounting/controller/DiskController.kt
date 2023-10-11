package com.emiryanvl.diskaccounting.controller

import com.emiryanvl.diskaccounting.dto.request.DiskRequest
import com.emiryanvl.diskaccounting.dto.response.DiskResponse
import com.emiryanvl.diskaccounting.service.DiskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/disk")
class DiskController (val diskService: DiskService) {
    @GetMapping("/{id}")
    fun getDisk(@PathVariable id: Long) : ResponseEntity<DiskResponse> {
        return ResponseEntity<DiskResponse>(diskService.get(id), HttpStatus.OK)
    }

    @GetMapping
    fun getDisks() : ResponseEntity<List<DiskResponse>> {
        return ResponseEntity<List<DiskResponse>>(diskService.getAll(), HttpStatus.OK)
    }

    @PostMapping
    fun createDisk(@RequestBody diskRequest: DiskRequest) : ResponseEntity<DiskResponse> {
        return ResponseEntity<DiskResponse>(diskService.create(diskRequest), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateDisk(@PathVariable id: Long, @RequestBody diskRequest: DiskRequest) : ResponseEntity<DiskResponse> {
        return ResponseEntity<DiskResponse>(diskService.update(id, diskRequest), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteDisk(@PathVariable id: Long) : ResponseEntity<Unit> {
        return ResponseEntity<Unit>(diskService.delete(id), HttpStatus.OK)
    }
}