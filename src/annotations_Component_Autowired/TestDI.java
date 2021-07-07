package annotations_Component_Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependencyInjection.A;

//Demo 2
//Demo of  @Component,@Autowired,@Value

//The @Autowired =annotation allows the container to automatically inject 
//the message property from the application-context.
//It is used on setter methods to get rid of <property> tag in xml ... 

//@Component = It is used to explicitly declare a single bean, rather than letting Spring do it automatically. 
//If any class is annotated with @Component it will be automatically detected by using classpath scan
public class TestDI {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/annotations_Component_Autowired/myConfig1.xml");
		
		//we used <context:component-scan base-package="annotations_Component_Autowired"></context:component-scan>
		//so no need to create object and bean separately like below
		
		//A obj1= (A) ctx.getBean("a"); //even if commented this..spring container loads all classes because of ApplicationContext
		//container as it is eager loading
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
