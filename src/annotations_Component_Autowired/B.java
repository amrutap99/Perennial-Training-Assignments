package annotations_Component_Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class B {
	String nameString;

	// 1.Note: default constructor with @Autowired gives exception:Autowired
	// annotation requires at least one argument..so dont use here
	//2. 1 st constructor wont called as 2nd constructor has @Autowired with
	// parameters and
	//3. parameters are essential for @Autowired
	//4. if u want to call this remove @autowired from 2nd constructor but dont use
	// @Autowired on 1 st constructor cause it is default constructor,it will get called automatically
	public B() {
		System.out.println("B created with default constructor");
	}

	@Autowired 
	public B(@Value("Amruta") String nameString) {
		System.out.println("B created and name is :" + nameString);
	}

}
