package edu.rit.multithreading.classlevel.synchronization;

/*
* File created on 29-Jun-2021 12:31:26 am
  File name : Professor3.java
  
*/

public class Professor3 extends Thread{
	public void run() {
		Classroom.teach(7);
	}

}
