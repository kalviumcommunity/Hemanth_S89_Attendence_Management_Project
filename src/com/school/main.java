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


        Course[]  courses = new Course[2];
        courses[0] = new Course();
        courses[0].setCourseDetails("CJAVA", "Java" );
        courses[1] = new Course();
        courses[1].setCourseDetails("CPYTHON", "Python" );


        System.out.println("---Registered Students---");
        for(Student student: students){
            if(student != null){
                student.getDetails();
            }
        }
        System.out.println("---Registered Courses---");
        for(Course course: courses){
           if(course != null){
            course.getCourseDetails();
           }
        }
        System.out.print("Session 2: Student and Course classes created.");
    }
}