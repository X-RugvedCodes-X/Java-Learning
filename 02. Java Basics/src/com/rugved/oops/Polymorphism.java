package com.rugved.oops;

class Airplane {
  public void takeOff() {
    System.out.println("Airplane Takes Off at Slow Speed");
  }
};

class FighterPlane extends Airplane {
  public void takeOff() {
    System.out.println("FighterPlane Takes Off at High Speed");
  }
};

class PassengerPlane  extends Airplane {
  public void takeOff() {
    System.out.println("PassengerPlane Takes Off at Medium Speed");
  }
};

class CargoPlane  extends Airplane {
  public void takeOff() {
    System.out.println("CargoPlane Takes Off at Very Slow Speed");
  }
};

class Airport {
  public void permit(Airplane airplane) {   //* DownCasting Happens here
    airplane.takeOff();
  }
};

public class Polymorphism {
  public static void main(String[] args) {
    System.out.println("hello, polymorphism");

    //* Polymorphism (1 : Many) Behaviour.

    FighterPlane fp   = new FighterPlane();
    PassengerPlane pp = new PassengerPlane();
    CargoPlane cp     = new CargoPlane();

    // Airplane airplane = new Airplane();
    // airplane.takeOff();

    // airplane = fp;        //* UpCasting 
    // airplane.takeOff();   //* Polymorphism Here: Same Statement Different Outputs

    // airplane = pp;
    // airplane.takeOff();   //* Polymorphism Here: Same Statement Different Outputs 

    // airplane = cp;
    // airplane.takeOff();   //* Polymorphism Here: Same Statement Different Outputs 

    //* Real Polymorphism Done here - One line executing different Instructions, This is Runtime Polymorphism
    Airport a = new Airport();
    a.permit(fp);
    a.permit(pp);
    a.permit(cp);
  }
};