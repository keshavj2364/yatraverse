package com.yatraverse.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatraverse.repository.TripRepository;
import com.yatraverse.repository.UserRepository;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;

    public Map<String, Object> getDashboardData() {

        Map<String, Object> map = new HashMap<>();

        map.put("totalUsers", userRepository.count());
        map.put("totalTrips", tripRepository.count());

        return map;
    }
}