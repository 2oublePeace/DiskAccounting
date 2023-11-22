package com.emiryanvl.reportservice.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
@Component
class ReportProperties {
    @Value("\${report-url}")
    lateinit var reportUrl: String
}