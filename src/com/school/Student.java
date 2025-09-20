// package com.school;

// public class Student extends Person{
//     // private int studentId;
//     // private String name;

//     // public Student(int studentId, String name) {
//     //     this.studentId = studentId;
//     //     this.name = name;
//     // }

//     // // Getters
//     // public int getStudentId() {
//     //     return studentId;
//     // }

//     // public String getName() {
//     //     return name;
//     // }
// private String gradeLevel;

// public Student(String name, String gradeLevel){
    
// }

// }


package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name); // Person assigns auto ID
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Student, Grade Level: " + gradeLevel);
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + gradeLevel;
    }
}
