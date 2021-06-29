package edu.rit.multithreading.classlevel.synchronization;

/*
* File created on 29-Jun-2021 12:23:24 am
  File name : Test.java
  
*/

public class Test {

	public static void main(String[] args) {
		
		Professor p1 = new Professor();
		p1.setName("Professor 1");
		p1.start();
		
		Professor2 p2 = new Professor2();
		p2.setName("Professor 2");
		p2.start();
		
		
		Professor3 p3 = new Professor3();
		p3.setName("Professor 3");
		p3.start();
	}

}
