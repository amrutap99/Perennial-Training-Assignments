package com.ritindia.methodreference;

/*
* There are Four type method reference:

   1.Static Method Reference.
   2.Instance Method Reference of a particular object.
   3.Instance Method Reference of an arbitrary object of a particular type.
   4.Constructor Reference.
*
*
* This is 1.Static Method Reference.->to sort
// with custom comparator
*
* syntax = Class::staticMethod


* */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee(1,"Amruta"));
        employees.add(new Employee(2,"Sakshi"));
        employees.add(new Employee(3,"Vaishnavi"));
        employees.add(new Employee(4,"Akshata"));

        // Use static method reference to
        // sort arraylist by name

        System.out.println("Sorting by name");
        Collections.sort(employees, Test1 :: sortByName);
        employees.stream().map(nm -> nm.getName()).forEach(System.out::println);



    }

    private static int sortByName(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
