package com.example.customer
import datadog.trace.api.CorrelationIdentifier
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter


@Component
class LoggingFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val traceId = MDC.get("dd.trace_id") ?: CorrelationIdentifier.getTraceId()
            val spanId = MDC.get("dd.span_id") ?: CorrelationIdentifier.getSpanId()
            MDC.put("TraceId", traceId ?: "")
            MDC.put("SpanId", spanId ?: "")
            filterChain.doFilter(request, response)
        } finally {
            MDC.clear()
        }
    }
}

