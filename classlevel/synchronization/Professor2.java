package edu.rit.multithreading.classlevel.synchronization;

/*
* File created on 29-Jun-2021 12:30:46 am
  File name : Professor2.java
  
*/

public class Professor2 extends Thread {
	public void run() {
		Classroom.teach(12);
	}

}
