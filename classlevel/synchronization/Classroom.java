
package edu.rit.multithreading.classlevel.synchronization;

/*
* File created on 29-Jun-2021 12:23:40 am
  File name : Classroom.java
  
*/

public class Classroom {

	synchronized static void teach(int hours) {
		for(int i=0;i<hours;i++) {
			System.out.println("*");
		}
		System.out.println(hours+" hours completed "+" by "+Thread.currentThread().getName());
	}
}
