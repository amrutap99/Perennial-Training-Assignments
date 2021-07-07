package dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Demo 1
//Demo of beans creation,scope=prototype,setter and constructor dependency injection
public class TestDI {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/dependencyInjection/myConfig.xml");
		A obj1 = (A) ctx.getBean("myBeanA");
		A obj2 = (A) ctx.getBean("myBeanA");

		System.out.println("____________________________________________________");

		System.out.println(obj1 == obj2);// true beacause spring container creates references once and stores it
											// and points to same obj....and also there is same bean 'myBeanA'
											// means only one obj per bean id
		// irrespective of how many times u call ctx.getBean();
		System.out.println("____________________________________________________");

		A obj3 = (A) ctx.getBean("myBeanA");
		A obj4 = (A) ctx.getBean("myBeanA1");
		System.out.println(obj3 == obj4); // false as obj3 and obj4 are created separately
											// means they point to different objs
											// and they have diiferent beans
		System.out.println("____________________________________________________");

		System.out.println("for 'myBeanA2' bean demonstrating scope=prototype...");
		A obj5 = (A) ctx.getBean("myBeanA2");
		A obj6 = (A) ctx.getBean("myBeanA2");
		A obj7 = (A) ctx.getBean("myBeanA2");
		// as many times we call ctx.getBean for "myBean2" which
		// is prototype scope those no of times diff references
		// will be created

		System.out.println(obj5 == obj6); // false cause scope=prototype and 2 diff objs are created
											// even there is same bean
											// default scope=singleton

	}

}
