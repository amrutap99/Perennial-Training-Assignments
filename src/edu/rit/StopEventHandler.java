package edu.rit;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class StopEventHandler implements ApplicationListener<ContextStoppedEvent> {

	@Override
	public void onApplicationEvent(ContextStoppedEvent event) {
		// TODO Auto-generated method stub
	      System.out.println("ContextStoppedEvent Received");

	}

}
