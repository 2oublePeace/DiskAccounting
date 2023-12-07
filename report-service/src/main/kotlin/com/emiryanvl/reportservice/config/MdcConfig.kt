package com.emiryanvl.reportservice.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
class MdcConfig {

    @Bean
    fun mdcFilter(): OncePerRequestFilter {
        return object : OncePerRequestFilter() {
            override fun doFilterInternal(
                    request: HttpServletRequest,
                    response: HttpServletResponse,
                    filterChain: FilterChain
            ) {
                val traceId = generateTraceId()
                MDC.put(getReportTraceId(), traceId)

                try {
                    filterChain.doFilter(request, response)
                } finally {
                    MDC.remove("traceId")
                }
            }
        }
    }

    private fun generateTraceId(): String {
        return java.util.UUID.randomUUID().toString()
    }

    companion object {
        fun getReportTraceId(): String {
            return "traceId"
        }
    }
}
