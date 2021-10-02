package com.pivottech.booking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    Long id;

  //  @ManyToOne
    //@JoinColumn(name = "teacher_id", referencedColumnName = "id")
   // @JoinColumn(name = "teacherId", referencedColumnName = "id")

    @ManyToOne
    @JoinColumn(name = "teacher_id")
  //  @JsonIgnore
    Teacher teacher;


    @NotNull
    DateTime startTime;

    @NotNull
    DateTime endTime;
}
