package com.ritindia.methodreference;

/*
* There are Four type method reference:

   1.Static Method Reference.
   2.Instance Method Reference of a particular object.
   3.Instance Method Reference of an arbitrary object of a particular type.
   4.Constructor Reference.
*
*
* This is 2.Instance Method Reference.->to sort
// with custom comparator
*
* Syntax = obj::instanceMethod


* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        //here instance of class is created
        Test2 test2 = new Test2();


        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee(4,"Amruta"));
        employees.add(new Employee(1,"Sakshi"));
        employees.add(new Employee(3,"Vaishnavi"));
        employees.add(new Employee(2,"Akshata"));


        // Use instance method reference
        // to sort arraylist by name
        System.out.println("Sorting by id");
        Collections.sort(employees, test2 :: sortById);
        employees.stream().map(number -> number.getId()).forEach(System.out::println);

    }

    private int sortById(Employee e1, Employee e2) {
        return e1.getId().compareTo(e2.getId());
    }
}
