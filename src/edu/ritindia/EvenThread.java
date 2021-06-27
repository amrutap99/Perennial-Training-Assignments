package edu.ritindia;

public class EvenThread extends Thread{
    Test test;

    public EvenThread(Test t){
        this.test = t;
    }


    public void run(){

        test.print("Even");


    }
}
