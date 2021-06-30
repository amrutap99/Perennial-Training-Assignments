package com.ritindia.functional;

@FunctionalInterface
public interface Drawable {

    void draw(String msg);  //abstract method

    // It can contain any number of Object class methods.
    int hashCode();
    String toString();
    boolean equals(Object obj);
}
