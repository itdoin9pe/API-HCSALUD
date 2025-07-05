package com.saludsystem.infrastructure.adapters.in.controllers;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final MeterRegistry meterRegistry;

    public TestController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/metrics")
    public String testMetrics() {
        meterRegistry.counter("test.counter").increment();
        return "Metrics test endpoint";
    }
}