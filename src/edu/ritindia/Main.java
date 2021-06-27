package edu.ritindia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Scanner sc = new Scanner(System.in);
    //static List<Employee> employees = new ArrayList<Employee>();
    static Set<Employee> employees = new HashSet<Employee>();


    public static void main(String[] args) {
	// write your code here

        addEmployees();

    }

    private static void addEmployees() {
        Employee employee = new Employee();

        System.out.println("Enter employee details:");

        System.out.println("Enter id:");
        int id = sc.nextInt();
        employee.setId(id);

        System.out.println("Enter name:");
        String name = sc.next();
        employee.setName(name);

        if (employees.size() == 0) {
            employees.add(employee);
            addEmployees();

        }

        System.out.println("Enter  choice :");
        System.out.println("1.Remove duplicates By id");
        System.out.println("2.Remove duplicates By name");
        System.out.println("3.Exit");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                removeByID(employee);
                break;
            case 2:
                removeByName(employee);
                break;

            case 3:
                System.exit(1);
                break;
        }

       System.out.println("Do u want add another employee? (y/n)");
        String option = sc.next();
        if (option.equals("y")) {
            addEmployees();
        }

    }

    private static void removeByName(Employee employee) {
        Integer isDuplicate = 0;
        for (Employee employeeObject : employees) {
            if ((employeeObject.getId().hashCode() == employee.getId().hashCode())
                    && (employeeObject.getId().equals(employee.getId()))) {
                isDuplicate = 1;

            }
        }

        if (isDuplicate == 0) {
            employees.add(employee);

        }
        else {
            employees.remove(employee);
        }
        System.out.println("After removing duplicates by Id");
        for(Employee emp : employees) {
            System.out.println("Id : "+emp.getId()+" , Name : "+emp.getName());
        }
        System.out.println("_______________________________________________________________");

    }

    private static void removeByID(Employee employee) {
        Integer isDuplicate = 0;
        for (Employee employeeObject : employees) {
            if ((employeeObject.getName().hashCode() == employee.getName().hashCode())
                    && (employeeObject.getName().equals(employee.getName())) ) {
                isDuplicate = 1;

            }
        }

        if (isDuplicate == 0) {
            employees.add(employee);
        }
        else {
            employees.remove(employee);
        }

        System.out.println("After removing duplicates by Names");
        for(Employee emp : employees) {
            System.out.println("Id : "+emp.getId()+" , Name : "+emp.getName());
        }
        System.out.println("_______________________________________________________________");

    }
}
