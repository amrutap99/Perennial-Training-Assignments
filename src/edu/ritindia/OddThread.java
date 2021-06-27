package edu.ritindia;

public class OddThread extends Thread{
    Test test;

    public OddThread(Test t){
        this.test = t;
    }


    public void run(){

        test.print("Odd");



    }
}
