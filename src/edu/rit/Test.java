package edu.rit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring's event handling is single-threaded so if an event is published, until and unless all the receivers get the message, 
//the processes are blocked and the flow will not continue. 
//Hence, care should be taken when designing your application if the event handling is to be used.
public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/edu/rit/config.xml");
		
		// Let us raise a start event.
	      ((AbstractApplicationContext) context).start();
		  
	      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	      obj.getMessage();

	      // Let us raise a stop event.
	      ((AbstractApplicationContext) context).stop();

	}

}
