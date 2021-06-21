package edu.ritindia;

public class Audi extends Car{      //Inheritance: extends keyword

    private int speed;  //encapsulation :private keyword
    private String engineType;

    public Audi(){
        //System.out.println("I am Audi Car");

    }

    public Audi(int speed, String engineType) {
        System.out.println("I am Audi Car");

        this.speed = speed;
        this.engineType = engineType;
    }

    public int getSpeed() {   //accessing private fields by getter & setter methods
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    void start() {
        System.out.println("Engine started...");
    }

    public String getVehicleName() {            // Runtime Polymorphism :method overriding
        this.vehicleName = "I am Audi ";
        return vehicleName;
    }
}
