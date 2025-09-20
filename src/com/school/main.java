// package com.school;

// public class main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the school attendence management system.");
//    System.out.println("Session 1: Project setupand orientation complete.");


//     }
    
// }


package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- School Management System ----");

        // Create objects
        Student student1 = new Student("Hemanth", "10th Grade");
        Student student2 = new Student("Sai", "9th Grade");
        Teacher teacher = new Teacher("Mr. John", "Mathematics");
        Staff staff = new Staff("Mary", "Clerk");

        // Display details
        System.out.println("\n--- Person Details ---");
        student1.displayDetails();
        System.out.println();
        student2.displayDetails();
        System.out.println();
        teacher.displayDetails();
        System.out.println();
        staff.displayDetails();

        // Create courses
        Course course1 = new Course(101, "Java");
        Course course2 = new Course(102, "Python");

        // Attendance log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Use student.getId() for attendance
        AttendanceRecord record1 = new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present");
        AttendanceRecord record2 = new AttendanceRecord(student2.getId(), course2.getCourseId(), "Absent");
        AttendanceRecord record3 = new AttendanceRecord(student1.getId(), course2.getCourseId(), "Holiday"); // invalid

        // Add to attendance list
        attendanceLog.add(record1);
        attendanceLog.add(record2);
        attendanceLog.add(record3);

        // Display attendance records
        System.out.println("\n--- Attendance Records ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

      
        FileStorageService storage = new FileStorageService();

        // Prepare lists for saving
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        // Save lists to text files
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");
    }
}



// package com.school;

// public class main {
//     public static void main(String[] args) {
//         System.out.println("----Attendance Management System----");

//         // --- Register Students ---
//         Student[] students = new Student[2];

//         students[0] = new Student();
//         students[0].registerStudent(1, "Hemanth");

//         students[1] = new Student();
//         students[1].registerStudent(2, "Sai");

//         System.out.println("---Registered Students---");
//         for (Student student : students) {
//             student.getStudentDetails();
//         }

//         // --- Register Courses ---
//         Course[] courses = new Course[2];

//         courses[0] = new Course();
//         courses[0].registerCourse("CJAVA", "Java");

//         courses[1] = new Course();
//         courses[1].registerCourse("CPYTHON", "Python");

//         System.out.println("---Registered Courses---");
//         for (Course course : courses) {
//             course.getCourseDetails();
//         }

//         // --- Mark Attendance ---
//         System.out.println("---Marking Attendance---");
//         Attendance[] attendanceRecords = new Attendance[2];

//         attendanceRecords[0] = new Attendance();
//         attendanceRecords[0].markAttendance(1, "CJAVA", true);

//         attendanceRecords[1] = new Attendance();
//         attendanceRecords[1].markAttendance(2, "CPYTHON", false);

//         for (Attendance attendance : attendanceRecords) {
//             if (attendance != null) {
//                 attendance.getAttendance();
//             }
//         }

//         System.out.println("Session 3: Attendance feature added.");
//     }
// }
