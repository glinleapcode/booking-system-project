package com.pivottech.booking.controller;

import com.pivottech.booking.model.Availability;
import com.pivottech.booking.model.Reservation;
import com.pivottech.booking.service.AvailabilityService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("availabilities")
public class AvailabilityController {
    final AvailabilityService availabilityService;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping("/")
    List<Availability> getAllAvailabilities() {
        return availabilityService.getAllAvailabilities();
    }

    @PostMapping("/")
    public Availability create(@Valid @RequestBody Availability availability) {
        this.availabilityService.createAvailability(availability);
        return availability;
    }

    @GetMapping("/{id}")
    public Availability getById(@PathVariable("id") long id) {
        Availability avail = this.availabilityService.getAvailabilityById(id);
        if (avail == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return avail;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        if (!this.availabilityService.deleteAvailability(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/datetime")
    public List<Availability> findByTime(@RequestParam("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) DateTime desired_time){
        return this.availabilityService.findAvailabilityByTime(desired_time);
    }

}
