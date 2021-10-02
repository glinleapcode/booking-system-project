package com.pivottech.booking.service;

import com.pivottech.booking.model.Availability;
import com.pivottech.booking.model.Reservation;
import com.pivottech.booking.repository.AvailabilityRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService {
    private final AvailabilityRepository availabilities;

    @Autowired
    public AvailabilityService(AvailabilityRepository availabilities) {
        this.availabilities = availabilities;
    }
    //Availabilities
    public List<Availability> getAllAvailabilities() {
        return (List<Availability>) availabilities.findAll();
    }

    public Availability createAvailability(Availability availability) {
        Availability saved = this.availabilities.save(availability);
        return saved;
    }

    public Availability getAvailabilityById(Long id) {
        Optional<Availability> avail = availabilities.findById(id);
        return avail.orElse(null);
    }

    public boolean deleteAvailability(Long id) {
        Availability toDelete = getAvailabilityById(id);
        if (toDelete == null) {
            return false;
        }
        this.availabilities.delete(toDelete);
        return true;
    }

    public List<Availability> findAvailabilityByTime(DateTime desired_time){
        return this.availabilities.findAvailabilityByTime(desired_time);

    }
}
