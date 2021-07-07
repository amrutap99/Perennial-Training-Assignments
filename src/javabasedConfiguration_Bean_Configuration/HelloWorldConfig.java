package javabasedConfiguration_Bean_Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// java based configuration for class HelloWorld
@Configuration
public class HelloWorldConfig {
	
	@Bean
	public HelloWorld helloworldMethod() {
		return new HelloWorld();
		
	}

}
