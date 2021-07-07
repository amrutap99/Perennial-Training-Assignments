package javabasedConfiguration_Bean_Configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Purpose of java based configuration=Java-based configuration option enables you to 
//write most of your Spring configuration without XML 
//but with the help of few Java-based annotations=@Configuration , @Bean

//1.@Configuration=indicates that the class can be used by the Spring IoC container as a source of bean definitions

//2.@Bean = tells Spring that a method annotated with @Bean will return an 
//object that should be registered as a bean in the Spring application context
public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		
		HelloWorld h1= ctx.getBean(HelloWorld.class);
		h1.setMsg("Hello");
		h1.getMsg();   //Hello

	}

}
