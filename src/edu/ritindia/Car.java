package edu.ritindia;

abstract class Car implements Vehicle{   //Interface : implements keyword
   private int speedLimit,noOfGears;

   private Engine engine;           //composition : Car has an engine

   protected String vehicleName;   //protected :accessible in child class

    abstract void start();         //abstract method overrided by child Audi class

    public Car(){
        System.out.println("I am abstract Car");
        this.engine = new Engine();
        engine.setEngineName("Anonymous Car Engine");

    }

    @Override
    public void getSpeed(int x) {
        this.speedLimit = x;
    }

    public void getSpeed(int x,String vehicleName){  //compile time polymorphism - same method(i.e speed()) with 2 different signatures
        this.speedLimit = x;
        this.vehicleName = vehicleName;
        System.out.println("Speed = "+speedLimit+" , Vehicle Name = "+vehicleName);
    }


    @Override
    public void getNoOfGears(int y) {
        this.noOfGears = y;
    }

    @Override
    public void displayDetails() {
        System.out.println("Displaying details...");
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = "Car";
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}


