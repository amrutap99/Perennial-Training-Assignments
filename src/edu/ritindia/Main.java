package edu.ritindia;
//lambda expression example 1-Runnable interface
public class Main {

    public static void main(String[] args) {
	// write your code here
        Runnable r1 = new Runnable() {   //without lambda expression
            @Override
            public void run() {
                System.out.println("Thread 1 running..");
            }
        };

        Thread t1= new Thread(r1);
        t1.start();

        Runnable r2 = () -> System.out.println("Thread 2 running..");  //with lambda expression
        Thread t2= new Thread(r2);
        t2.start();




    }
}
