package com.pivottech.booking.repository;

import com.pivottech.booking.model.Availability;
import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AvailabilityRepository extends PagingAndSortingRepository<Availability, Long> {

    @Query("SELECT a From Availability a WHERE a.startTime >= :desired_time ")
    List<Availability> findAvailabilityByTime(@Param("desired_time") DateTime desired_time);
}
