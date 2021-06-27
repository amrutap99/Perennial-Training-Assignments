package edu.ritindia;

public class Test {

    synchronized void print(String str){
        if (str.equals("Even")){
            for (int i=0;i<=10;i+=2){
                System.out.println(i);

                try {
                    //System.out.println("even thread sleeping");
                        Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        else {
            for (int i=1;i<=10;i+=2){
                System.out.println(i);

                try {
                    //System.out.println("odd thread sleeping");

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }




}
