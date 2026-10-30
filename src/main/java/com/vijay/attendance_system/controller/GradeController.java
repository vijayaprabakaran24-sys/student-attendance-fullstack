package com.vijay.attendance_system.controller;

import com.vijay.attendance_system.model.Grade;
import com.vijay.attendance_system.repository.GradeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin(origins = "*")
public class GradeController {

    private final GradeRepository gradeRepository;

    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @PostMapping
    public Grade add(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getByStudent(@PathVariable Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
}