package com.yatraverse.service;

import com.yatraverse.entity.Trip;
import com.yatraverse.repository.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip addTrip(Trip trip) {

        return tripRepository.save(trip);
    }

    public List<Trip> getTripsByUser(
            String email) {

        return tripRepository
                .findByUserEmail(email);
    }

    public Trip updateTrip(
            Long id,
            Trip updatedTrip) {

        Trip trip =
                tripRepository.findById(id)
                .orElseThrow();

        trip.setTitle(updatedTrip.getTitle());
        trip.setDestination(updatedTrip.getDestination());
        trip.setBudget(updatedTrip.getBudget());
        trip.setDescription(updatedTrip.getDescription());

        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {

        tripRepository.deleteById(id);
    }
}