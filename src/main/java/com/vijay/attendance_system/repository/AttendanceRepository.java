package com.vijay.attendance_system.repository;

import com.vijay.attendance_system.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
    long countByStudentId(Long studentId);
    long countByStudentIdAndPresentTrue(Long studentId);
}