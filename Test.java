package edu.rit.multithreading;

/*
* File created on 28-Jun-2021 11:09:59 pm
  File name : Test.java
  
  Problem:
  1.Implement synchronized method 
  
*/

public class Test {

	public static void main(String[] args) {
		
		//Customer customer = new Customer();
		
		Customer1 customer1 = new Customer1();

		
		Thread t1 = new Thread() {
			public void run() {
				customer1.withdraw(2000);
			}
		};
		
		t1.setName("Thread 1");
		t1.start();
		
		Thread t2 =new Thread() {
			public void run() {
				customer1.withdraw(12000);
			}
		};
		
		t2.setName("Thread 2");
		t2.start();
		
		Thread t3 =new Thread() {
			public void run() {
				customer1.withdraw(10000);
			}
		};
		
		t3.setName("Thread 3");
		t3.start();
		
	}

}
