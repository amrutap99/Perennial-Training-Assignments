package edu.ritindia;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Test test = new Test();
        EvenThread t1 = new EvenThread(test);
        OddThread t2 = new OddThread(test);
        t1.start();
        t2.start();
    }
}
