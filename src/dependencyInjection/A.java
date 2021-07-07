package dependencyInjection;


public class A {

	B b;

	A(){   
		System.out.println("A created with default constructor");
	}
	
	A(B b){
		this.b =b;
		System.out.println("A created with B");
	}
	
	
	//if property name is  <property name="b" ref ="myBeanB"></property>
	//then spring will search for a setter method with name setB() in A class
	public void setB(B b) {
		System.out.println("setB() called with b");
	}
}
