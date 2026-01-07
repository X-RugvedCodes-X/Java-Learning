package com.rugved.main;

// import com.rugved.services.BlueDart;
// import com.rugved.services.FedEx;
import com.rugved.services.FirstFlight;

public class LaunchAmazon {
  public static void main(String[] args) {
    // * This All phenomenon is called Loose Coupling and the Application is loosely coupled.
    System.out.println("Launch Amazon");
    // Amazon amazon = new Amazon(); 

    // * This is called Setter Injection
    // amazon.setService(new FedEx());
    // FedEx fedex = new FedEx();
    // amazon.setService(fedex);

    // amazon.setService(new BlueDart());

    // * When Spring Framework creates this object under the hood, it is called Spring Bean.
    Amazon amazon = new Amazon(new FirstFlight()); // * <-- This is Called Dependency Constructor Injection

    Boolean status = amazon.deliverProduct(450.43);

    System.out.println(status ? "Product Delivered Successfully." : "Product Delivery Failure");

    // ^ Interview Question - When we perform constructor injection and setter injection at the same time then the last created object will be used which means the setter injection will be used
  }
};