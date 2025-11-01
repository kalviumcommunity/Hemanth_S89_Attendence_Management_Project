package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
        this.attendanceLog = new ArrayList<>();
    }

    // Mark attendance using objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Marked attendance: " + record.toDataString());
    }

    // Mark attendance using IDs with RegistrationService lookup
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        if (student == null) {
            System.out.println("\u274c Student with ID " + studentId + " not found.");
            return;
        }
        if (course == null) {
            System.out.println("\u274c Course with ID " + courseId + " not found.");
            return;
        }
        markAttendance(student, course, status);
    }

    public void displayAttendanceLog() {
        System.out.println("\n--- Attendance Log (All) ---");
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance Log for Student: " + student.getName() + " (ID: " + student.getId() + ") ---");
        List<AttendanceRecord> filtered = attendanceLog.stream()
            .filter(r -> r.getStudent().getId() == student.getId())
            .collect(Collectors.toList());
        for (AttendanceRecord r : filtered) r.displayRecord();
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance Log for Course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ") ---");
        List<AttendanceRecord> filtered = attendanceLog.stream()
            .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
            .collect(Collectors.toList());
        for (AttendanceRecord r : filtered) r.displayRecord();
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
