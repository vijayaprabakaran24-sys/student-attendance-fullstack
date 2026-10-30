package com.vijay.attendance_system.repository;

import com.vijay.attendance_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}