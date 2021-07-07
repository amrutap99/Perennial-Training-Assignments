package edu.ritindia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//Program 1 of Strategy mapping
//Demo of Table per class hierarchy Strategy mapping
/*Included files:
 * 1.Vehicle.java,Car.java,Scooter.java
 * 2.Vehicle.hbm.xml
 * 3.hibernate.cfg.xml
 * 
 * 
 *1.Here I have Vehicle superclass and Scooter and Car are its subclasses which are inherited
 *2.Aim=Using discriminator tag  we can separate properties of each class
 *
 *In Table per class hierarchy , we get single table and aproperties of all classes are added together
 *Therefore no of columns= sum of properties of all classes that are mapped 
 * */

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction txn = session.beginTransaction();
		
		Vehicle v1 = new Vehicle();
		v1.setModelNo(1234);
		v1.setVehicleBrand("Mercedes Benz Skoda");
		
		Scooter scooter = new Scooter();
		scooter.setModelNo(567);
		scooter.setModelName("Honda Dio");
		scooter.setRegNo(9090);
		scooter.setVehicleBrand("PQR");
		
		
		Car car = new Car();
		car.setVehicleBrand("Jeep Volkswagen");
		car.setEngineType("STY");
		car.setModelType("XYZ");
		car.setModelNo(3455);
		
		session.save(v1);
		session.save(car);
		session.save(scooter);
		
		txn.commit();

	}

}
