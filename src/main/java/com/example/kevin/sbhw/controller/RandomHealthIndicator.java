package com.example.kevin.sbhw.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Health.Builder status = Health.up();
        return status.build();
    }
}
