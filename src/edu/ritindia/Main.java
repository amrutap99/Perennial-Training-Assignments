package edu.ritindia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem:
 *   1.Implement custom exception
 *   2.Check whether finally block executes after exception occurs in catch block->Yes it executes..
 */



public class Main {

    static List<Student> students = new ArrayList<Student>();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ExistingStudentException {
	// write your code here

        //added sample list of students
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("adiraamruta");
        students.add(s1);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("adira");
        students.add(s2);

        while(true) {
            System.out.println("1 Add a student ");
            System.out.println("2 Exit ");

            System.out.println("Make a choice");
            int choice = sc.nextInt();
            switch(choice) {

                case 1 : try {

                    addStudent();

                } catch (ExistingStudentException e) {

                    int c = 10/0;    //runtime exception

                    System.out.println("Exception occurred !");
                    //throw new ExistingStudentException("Exists");


                    //e.printStackTrace();
                }
                finally {
                    System.out.println("Code continues");    //executes even if exception occurs in catch block
                }

                    break;

                case 2 : System.exit(1);
            }

        }


    }


    private static void addStudent() throws ExistingStudentException {
        Student student = new Student();

        System.out.println("Enter id :");
        int id = sc.nextInt();
        student.setId(id);

        System.out.println("Enter name :");
        String name = sc.next();
        student.setName(name);

        System.out.println("user input student :"+student);




        Integer isDuplicate =0;
        for (Student studentObject : students) {
            if ( (studentObject.getName().hashCode() == student.getName().hashCode() && studentObject.getName().toString().equals(student.getName().toString()) )
                    && ( studentObject.getId().hashCode() == student.getId().hashCode() && studentObject.getId().toString().equals(student.getId().toString()) )  ) {
                throw new ExistingStudentException("Student Exists Already ...");
            }
        }
        if(isDuplicate == 0) {
            students.add(student);
        }

        display();


    }


    private static void display() {
        for(Student student:students) {
            System.out.println(student);
        }
    }

}
