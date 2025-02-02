package com.pivottech.booking.model;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder()
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    Long id;


  //  @ManyToOne
  //  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  //  Teacher teacher;

    @NotNull
    DateTime startTime;

    @NotNull
    DateTime endTime;

    @NotEmpty
    String description;

}
