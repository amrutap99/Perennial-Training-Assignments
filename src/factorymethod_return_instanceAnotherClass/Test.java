package factorymethod_return_instanceAnotherClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Demo for factory bean=represents the reference of the bean by which factory method will be invoked. 
//It is used if factory method is non-static.
//Here factory method=PrintableFactoryMethod()
//simple code to inject the dependency by non static factory method that returns the instance of another class.
//Files -(Interface)Printable.java ,A.java,B.java,PrintableFactory.java,applicationContext.xml,Test.java

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/factorymethod_return_instanceAnotherClass/applicationContext.xml");

		Printable p1 = (Printable) ctx.getBean("p");
		p1.print(); // Hello A
		// if want instance of B class then return new B() in PrintableFactoryMethod

	}

}
