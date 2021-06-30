package com.ritindia.methodreference;

public class Car{

    private String name;

    public Car(String name) {
        this.name = name;
        System.out.println("Car name = "+this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
