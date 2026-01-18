package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.HealthCheck;
import com.example.demo.Enum.ApplicationStatus;
import com.example.demo.Repository.HealthCheckRepository;

@Service
public class HealthCheckService {

    @Autowired
    private HealthCheckRepository healthCheckRepository;

    public HealthCheck getHealthStatus() {

        Long conectionCount = healthCheckRepository.countApplicationConnections();

        if (conectionCount > 0) {
            return new HealthCheck(ApplicationStatus.OK, "API is running and connected to the database.");
        }
        else {
            return new HealthCheck(ApplicationStatus.KO, "API is running but not connected to the database.");
        }

    }
}
