package edu.rit;

/*1.  Event handling in the ApplicationContext is provided through the ApplicationEvent class and
	ApplicationListener interface. Hence, if a bean implements the ApplicationListener, then every time an 
	ApplicationEvent gets published to the ApplicationContext, that bean is notified.
 *
 * 2.To listen to a context event, a bean should implement the ApplicationListener interface
 *   which has just one method onApplicationEvent(). 
 * 
 * 
 * 
 * 
 * */

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;


public  class StartEventHandler implements ApplicationListener<ContextStartedEvent> {

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		// TODO Auto-generated method stub
	      System.out.println("ContextStartedEvent Received");

		
	}

}
