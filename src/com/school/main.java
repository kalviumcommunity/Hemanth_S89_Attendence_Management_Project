// package com.school;

// public class main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the school attendence management system.");
//    System.out.println("Session 1: Project setupand orientation complete.");


//     }
    
// }



package com.school;


public class main{
    public static void main(String[] args){
        System.out.println("----Attendence Management System----");
        Student[] students = new Student[2];
        students[0] = new Student();
        students[0].setStudentDetails(1, "Hemanth" );
        students[1] = new Student();
        students[1].setStudentDetails(2, "Sai" );

         System.out.println("---Registered Students---");
        for(Student student: students){
            if(student != null){
                student.getDetails();
            }
        }


        Course[]  courses = new Course[2];
        courses[0] = new Course();
        courses[0].setCourseDetails("CJAVA", "Java" );
        courses[1] = new Course();
        courses[1].setCourseDetails("CPYTHON", "Python" );


       
        System.out.println("---Registered Courses---");
        for(Course course: courses){
           if(course != null){
            course.getCourseDetails();
           }
        }

        System.out.println("---Marking Attendance---");
        Attendance[] attendanceRecords = new Attendance[2];

         attendanceRecords[0] = new Attendance();
          attendanceRecords[0].markAttendance(1, "CJAVA", true);

         attendanceRecords[1] = new Attendance();
         attendanceRecords[1].markAttendance(2, "CPYTHON", false);

       for (Attendance attendance : attendanceRecords) {
           if (attendance != null) {
             attendance.getAttendance();
          }
}




        System.out.println("Session 2: Student and Course classes created.");
        System.out.println("Session 3: Attendance feature added.");
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
