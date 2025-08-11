package com.school;


public class Course {
    String courseId;
    String courseName;

    public void setCourseDetails(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public void getCourseDetails() {
        System.out.println("Course ID: " + this.courseId);
        System.out.println("Course Name: " + this.courseName);
    }
}