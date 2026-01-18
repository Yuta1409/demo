package com.example.demo;

import com.example.demo.Enum.ApplicationStatus;

public record HealthCheck(ApplicationStatus status, String message) { }
