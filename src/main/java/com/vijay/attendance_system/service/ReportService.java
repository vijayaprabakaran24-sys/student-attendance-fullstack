package com.vijay.attendance_system.service;

import com.vijay.attendance_system.model.Grade;
import com.vijay.attendance_system.model.Student;
import com.vijay.attendance_system.model.StudentReport;
import com.vijay.attendance_system.repository.AttendanceRepository;
import com.vijay.attendance_system.repository.GradeRepository;
import com.vijay.attendance_system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private static final double MIN_ATTENDANCE = 75.0;

    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    private final GradeRepository gradeRepository;

    public ReportService(StudentRepository studentRepository,
                         AttendanceRepository attendanceRepository,
                         GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.attendanceRepository = attendanceRepository;
        this.gradeRepository = gradeRepository;
    }

    public StudentReport buildReport(Student s) {
        long total = attendanceRepository.countByStudentId(s.getId());
        long present = attendanceRepository.countByStudentIdAndPresentTrue(s.getId());
        double percentage = total == 0 ? 0 : round(present * 100.0 / total);

        List<Grade> grades = gradeRepository.findByStudentId(s.getId());
        double average = round(grades.stream().mapToInt(Grade::getMarks).average().orElse(0));

        boolean eligible = total > 0 && percentage >= MIN_ATTENDANCE;
        String grade = grades.isEmpty() ? "N/A" : calculateGrade(average);

        return new StudentReport(s.getId(), s.getRollNo(), s.getName(),
                total, present, percentage, eligible, average, grade);
    }

    public List<StudentReport> buildAllReports() {
        return studentRepository.findAll().stream().map(this::buildReport).toList();
    }

    private String calculateGrade(double average) {
        if (average >= 80) return "A";
        if (average >= 65) return "B";
        if (average >= 50) return "C";
        return "D";
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}