package com.pivottech.booking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

   // @Column(name = "teacher_id")
    Long id;
    String name;

 //   @OneToMany(mappedBy = "teacher")
   // @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    List<Availability> availabilities;
}
