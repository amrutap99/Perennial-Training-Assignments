package aspect_before_after_around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/aspect_before_after_around/AdviceConfig.xml");  
        Operation e = (Operation) context.getBean("operationBean");  
        System.out.println("calling msg...");  
        e.msg();
        System.out.println("_______________________________________________________________________");
        System.out.println("calling m...");  
        e.m();
        System.out.println("_______________________________________________________________________");
        
	}

}
