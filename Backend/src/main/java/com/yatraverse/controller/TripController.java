package com.yatraverse.controller;

import com.yatraverse.entity.Trip;
import com.yatraverse.service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin("*")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping
    public Trip addTrip(
            @RequestBody Trip trip) {

        return tripService.addTrip(trip);
    }

    @GetMapping("/{email}")
    public List<Trip> getTripsByUser(
            @PathVariable String email) {

        return tripService
                .getTripsByUser(email);
    }

    @PutMapping("/{id}")
    public Trip updateTrip(
            @PathVariable Long id,
            @RequestBody Trip trip) {

        return tripService.updateTrip(id, trip);
    }

    @DeleteMapping("/{id}")
    public String deleteTrip(
            @PathVariable Long id) {

        tripService.deleteTrip(id);

        return "Trip Deleted";
    }
}