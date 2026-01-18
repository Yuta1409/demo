package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.HealthCheck;
import com.example.demo.Service.HealthCheckService;

@RestController
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping("healthcheck")
    public HealthCheck healthcheck() {
        return healthCheckService.getHealthStatus();
    }

}
