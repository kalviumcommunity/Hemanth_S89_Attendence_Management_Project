// package com.school;

// public class main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the school attendence management system.");
//    System.out.println("Session 1: Project setupand orientation complete.");


//     }
    
// }


package com.school;

import java.util.List;

public class Main {
    // Polymorphic directory display using RegistrationService
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory (Polymorphic Display) ---");
        List<Person> people = regService.getAllPeople();
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("---- School Management System ----");

        // Instantiate services with dependency injection
        FileStorageService storage = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, registrationService);

        // Register students, teachers, staff using RegistrationService
        registrationService.registerStudent("Hemanth", "10th Grade");
        registrationService.registerStudent("Sai", "9th Grade");
        registrationService.registerTeacher("Mr. John", "Mathematics");
        registrationService.registerStaff("Mary", "Clerk");

        // Create courses using RegistrationService
        registrationService.createCourse(101, "Java");
        registrationService.createCourse(102, "Python");

        // Polymorphic display using RegistrationService
        displaySchoolDirectory(registrationService);

        // Get student and course IDs for attendance marking
        int student1Id = registrationService.getStudents().get(0).getId();
        int student2Id = registrationService.getStudents().get(1).getId();
        int course1Id = registrationService.getCourses().get(0).getCourseId();
        int course2Id = registrationService.getCourses().get(1).getCourseId();

        // Mark attendance using ID-based method
        attendanceService.markAttendance(student1Id, course1Id, "Present");
        attendanceService.markAttendance(student2Id, course2Id, "Absent");
        attendanceService.markAttendance(student1Id, course2Id, "Present");

        // Display attendance logs
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(registrationService.getStudents().get(0));
        attendanceService.displayAttendanceLog(registrationService.getCourses().get(1));

        // Save all data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
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
