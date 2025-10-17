package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // Mark attendance using objects
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
        System.out.println("Marked attendance: " + record.toDataString());
    }

    // Mark attendance using IDs and lookup lists
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);
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

    private Student findStudentById(int id, List<Student> students) {
        if (students == null) return null;
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> courses) {
        if (courses == null) return null;
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
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
