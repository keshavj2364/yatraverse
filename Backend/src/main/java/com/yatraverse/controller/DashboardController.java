package com.yatraverse.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yatraverse.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public Map<String, Object> dashboard() {
        return dashboardService.getDashboardData();
    }
}