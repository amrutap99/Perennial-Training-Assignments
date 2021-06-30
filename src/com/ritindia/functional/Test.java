package com.ritindia.functional;
/*
* Functional interface
*
* */
public class Test implements Drawable {
    public static void main(String[] args) {

        Drawable drawable = new Test();
        drawable.draw("Drawing shape");

    }

    @Override
    public void draw(String msg) {
        System.out.println(msg);
    }
}
