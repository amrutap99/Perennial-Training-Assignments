package com.ritindia.methodreference;

/*
* There are Four type method reference:

   1.Static Method Reference.
   2.Instance Method Reference of a particular object.
   3.Instance Method Reference of an arbitrary object of a particular type.
   4.Constructor Reference.
*
*
* This is - 4.Reference to a Constructor->here Referring constructor with the help of functional interface.
* Files included - 1.Vehicle (functional interface)
*
* Syntax = className :: new


* */

public class Test3 {

    public static void main(String[] args) {
        Vehicle vehicle = Car::new;
        vehicle.getCar("Audi");
    }
}
