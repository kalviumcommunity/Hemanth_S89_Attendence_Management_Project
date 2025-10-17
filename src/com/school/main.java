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
    // Polymorphic directory display
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory (Polymorphic Display) ---");
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("---- School Management System ----");

        // Create objects
        Student student1 = new Student("Hemanth", "10th Grade");
        Student student2 = new Student("Sai", "9th Grade");
        Teacher teacher = new Teacher("Mr. John", "Mathematics");
        Staff staff = new Staff("Mary", "Clerk");

        // Demonstrate polymorphism by creating a list of Person references
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(student1);
        schoolPeople.add(student2);
        schoolPeople.add(teacher);
        schoolPeople.add(staff);

        // Polymorphic display - each object's overridden displayDetails() will run
        displaySchoolDirectory(schoolPeople);

        // Create courses
        Course course1 = new Course(101, "Java");
        Course course2 = new Course(102, "Python");

        // --- Storage & Attendance Service ---
        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        // Prepare lists for lookups and saving
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(student1);
        allStudents.add(student2);

        List<Course> allCourses = new ArrayList<>();
        allCourses.add(course1);
        allCourses.add(course2);

        // Use overloaded markAttendance methods
        attendanceService.markAttendance(student1, course1, "Present");
        attendanceService.markAttendance(student2, course2, "Absent");
        // Use ID-based overload which will lookup objects
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Present", allStudents, allCourses);

        // Display different views
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(student1);
        attendanceService.displayAttendanceLog(course2);

        // Save attendance data via service
        attendanceService.saveAttendanceData();

      
        // Prepare lists for saving (students and courses)
        List<Student> students = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                students.add((Student) p);
            }
        }

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        // Save lists to text files
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
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
