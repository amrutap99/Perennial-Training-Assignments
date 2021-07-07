package factorymethod_return_instanceAnotherClass;


//this is factory method =A method that returns instance of a class is called factory method.
public class PrintableFactoryMethod {
	
	public Printable getPrintable() {//register this method & class in xml file
		return new A();   //return any one instance, either A or B  
		
	}

}
//Note:
//if factory method is non static then only we can use ..factory-bean ..in xml factory-bean="" use id of
//first bean ..see xml file 
//if factory method is static then we can use ..factory-method .. in xml use only static method for this 