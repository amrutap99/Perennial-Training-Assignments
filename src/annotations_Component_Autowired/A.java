package annotations_Component_Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class A {

	B b;
	String msgString;

	// @Autowired ..gives exception:Autowired annotation requires at least one
	// argument..so dont use here
	public A() {
		System.out.println("A created with default constructor");
	}

	@Autowired
	public A(B b, @Value("Hello") String msgString) {
		System.out.println("A created with parameterized constructor and msg is " + msgString);

	}

	// if above method have annotation @Autowired then below method at the same time
	// cant have @Autowired
	// cause exception: Found constructor with 'required' Autowired annotation
	// already

	public A(B b) {
		this.b = b;
		System.out.println("A created with parameterized constructor with B");
	}

	// if property name is <property name="b" ref ="myBeanB"></property>
	// then spring will search for a setter method with name setB() in A class
	@Autowired
	public void setB(B b) {
		System.out.println("setB() called with b");
	}

	 									// The @PostConstruct annotation is used on a method that needs to be
	@PostConstruct						// executed after dependency injection is done to perform any initialization.
	public void initialize() {
		System.out.println("\nAfter bean creation setting up environment for 'myBeanA'");
	}

	
	  	                    // method gets called when bean instance is getting removed from the context.So use ctx.close()
	@PreDestroy				// when we remove scope=prototype this line will be executed otherwise not printed
	public void cleanup() {
		System.out.println("Object is about to removed from container");
	}

}
