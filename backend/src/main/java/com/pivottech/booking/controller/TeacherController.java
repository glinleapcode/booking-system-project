package com.pivottech.booking.controller;

import com.pivottech.booking.exceptions.TeacherNameEmptyException;
import com.pivottech.booking.model.Teacher;
import com.pivottech.booking.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {
    final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping("/")
    public ResponseEntity<String> addTeacher(@Valid @RequestBody Teacher teacher) {
        try {
            Teacher savedStudent = teacherService.addTeacher(teacher);
            return ResponseEntity.ok("Added a Teacher." + teacher.toString());

        } catch(TeacherNameEmptyException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }

    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable("id") long id) {
        Teacher teacher = this.teacherService.getTeacherById(id);
        if(teacher == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return teacher;

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        if (!this.teacherService.deleteTeacher(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
