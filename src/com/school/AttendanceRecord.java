package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            this.status = "Invalid";
            System.out.println("\u26a0\ufe0f Warning: Invalid status entered. Defaulting to 'Invalid'.");
        }
    }

    // Getters
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Display method - richer output using object references
    public void displayRecord() {
        System.out.println("Student: " + student.getName() + " (ID: " + student.getId() + ")"
            + " | Course: " + course.getCourseName() + " (ID: " + course.getCourseId() + ")"
            + " | Status: " + status);
    }

    @Override
    public String toDataString() {
        // Keep using IDs for file storage compatibility
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
