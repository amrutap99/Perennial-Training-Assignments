package edu.ritindia;



public class Main  {

    public static void main(String[] args) {
        Audi audi = new Audi(250,"In Line Petrol Engine");
        //audi.setEngineType("Petrol");
        //audi.getEngineType();
        audi.displayDetails();         //Inheritance : accessing parent method

        System.out.println("Engine Type = "+audi.getEngineType()+"  Speed = "+audi.getSpeed());


        System.out.println("-------------------------------------------------------------------------");

        Car c = new Audi();
        System.out.println(c.getVehicleName()) ;    //dynamic method dispatch

        System.out.println("-------------------------------------------------------------------------");

        //abstract class cannot be instantiated
        Car car1 = new Audi();                                     //Run time polymorphism/dynamic method dispatch

        car1.getSpeed(300,"Mercedez Benz");          //compile time polymorphism

        System.out.println("-------------------------------------------------------------------------");

        //composition
        System.out.println(car1.getEngine());







    }
}
