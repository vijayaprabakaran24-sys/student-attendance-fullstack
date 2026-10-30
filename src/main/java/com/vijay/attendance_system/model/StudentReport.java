package com.vijay.attendance_system.model;

public record StudentReport(
        Long studentId,
        String rollNo,
        String name,
        long totalClasses,
        long presentClasses,
        double attendancePercentage,
        boolean eligible,
        double averageMarks,
        String grade
) {}