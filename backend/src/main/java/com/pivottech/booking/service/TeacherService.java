package com.pivottech.booking.service;

import com.pivottech.booking.exceptions.TeacherNameEmptyException;
import com.pivottech.booking.exceptions.TeacherNotExsitException;
import com.pivottech.booking.model.Teacher;
import com.pivottech.booking.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teachers;

    @Autowired
    public TeacherService(TeacherRepository teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teachers.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        if(teacher.getName().isEmpty()) {
            throw new TeacherNameEmptyException("Teacher Name cannot be empty");
        }
        Teacher saved = this.teachers.save(teacher);
        return saved;
    }

    public Teacher updateTeacher(Teacher teacher) {
        if(teacher.getId() == null || !teachers.existsById(teacher.getId())) {
            throw new TeacherNotExsitException("Cannot find teacher id");
        }
        return teachers.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher = teachers.findById(id);
        return teacher.orElse(null);
    }

    public boolean deleteTeacher(Long id) {
        Teacher toDelete = getTeacherById(id);
        if(toDelete == null) {
            return false;
        }
        this.teachers.delete(toDelete);
        return true;
    }

}
