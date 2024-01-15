package com.emiryanvl.gateway.config

import org.apache.commons.logging.LogFactory
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono


@Component
class TraceIdFilter : GlobalFilter {

    private val log = LogFactory.getLog(TraceIdFilter::class.java)

    override fun filter(exchange: ServerWebExchange?, chain: GatewayFilterChain?): Mono<Void> {
        log.info("The tracing ID of the request: " + java.util.UUID.randomUUID().toString())
        return chain?.filter(exchange) ?: throw Exception("Filter is null")
    }
}