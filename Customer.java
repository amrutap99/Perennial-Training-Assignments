package edu.rit.multithreading;

/*
* File created on 28-Jun-2021 11:10:55 pm
  File name : Customer.java
  
*/

public class Customer {
	
	int amount = 10000;
	
	synchronized void withdraw(int amount) {                          //synchronized method demo
		
		System.out.println(Thread.currentThread().getName() +"  Current balance : "+this.amount);
		
		System.out.println("Withdrawing : "+amount);
		
		if(this.amount < amount) {
			
			System.out.println("Less balance..plz wait..depositing");
			
			this.amount += 5000;                                                    //depositing money till condition satisfies
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			System.out.println("Current balance = : "+this.amount);
			
			withdraw(amount);
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Withdrawing..plz wait..");

			this.amount = this.amount-amount;
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Withdraw completed for "+Thread.currentThread().getName()+"  Balance :"+this.amount);
			System.out.println("----------------------------------------------------------");

		}
		
	}
	

}
