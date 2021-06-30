package edu.ritindia;

/*lambda expression example 1-comparator
Files included :
1. edu.ritindia.Test.java
2. edu/ritindia/bo/Student.java
 */


import edu.ritindia.bo.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    private static List<Student> students = new ArrayList<Student>();
    public static void main(String[] args) {

        students.add(new Student(1,"Vaishnavi"));
        students.add(new Student(2,"Amruta"));
        students.add(new Student(3,"Sakshi"));

        System.out.println("Sorting on the basis of name...");

        Collections.sort(students, (s1,s2) -> {
            return s1.getName().compareTo(s2.getName());
        });

        System.out.println("After Sorting");

        students.forEach( student -> System.out.println(student));
    }
}
