package edu.rit.multithreading.classlevel.synchronization;

/*
* File created on 29-Jun-2021 12:24:35 am
  File name : Professor.java
  
*/

public class Professor extends Thread {
	
	public void run() {
		Classroom.teach(4);
	}

}
