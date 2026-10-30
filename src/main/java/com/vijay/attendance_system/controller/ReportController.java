package com.vijay.attendance_system.controller;

import com.vijay.attendance_system.model.StudentReport;
import com.vijay.attendance_system.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<StudentReport> getAll() {
        return reportService.buildAllReports();
    }
}
