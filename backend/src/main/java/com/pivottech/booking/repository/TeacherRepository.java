package com.pivottech.booking.repository;

import com.pivottech.booking.model.Reservation;
import com.pivottech.booking.model.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherRepository extends PagingAndSortingRepository <Teacher, Long>{
}
