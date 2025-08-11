package com.school;


public class Student {
    int studentId;
    String name;
    public void setStudentDetails(int id, String studentName){
        this.studentId = id;
        this.name = studentName;
    }

    public void getDetails(){
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Student Name: " + this.name);
    }
}