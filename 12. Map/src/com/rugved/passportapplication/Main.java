package com.rugved.passportapplication;

import java.util.HashMap;
// import java.util.Iterator;
// import java.util.Map;
import java.util.Scanner;
// import java.util.Set;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello, Passport Application");
    Passport person1 = new Passport("Rugved", "Mumbai", 21);
    Passport person2 = new Passport("Hyder", "Bengaluru", 29);
    Passport person3 = new Passport("Naveen", "Bengaluru", 40);

    Integer id1 = Integer.valueOf(101);
    Integer id2 = Integer.valueOf(201);
    Integer id3 = Integer.valueOf(301);

    HashMap<Integer, Passport> passportDB = new HashMap<Integer, Passport>();
    passportDB.put(id1, person1);
    passportDB.put(id2, person2);
    passportDB.put(id3, person3);
    // System.out.println(passportDB);

    
    System.out.print("Enter Your Passport ID: ");
    Scanner sc = new Scanner(System.in);
    Integer enteredPassportID = Integer.valueOf(sc.nextInt());
    
    // Set<Map.Entry<Integer, Passport>> passportSets = passportDB.entrySet();
    // Iterator<Map.Entry<Integer, Passport>> it = passportSets.iterator();
    // Boolean flag = false;
    // while(it.hasNext()) {
    //   Map.Entry<Integer, Passport> pair = it.next();
    //   if(enteredPassportID.equals(pair.getKey())) {     // * Since Integer Class is there, we use .equals instead of == 
    //     System.out.println("Your Passport Details Are Given Below");
    //     System.out.println(pair.getValue());
    //     flag = true;
    //     break;
    //   }
    // }
    // sc.close();
    // System.out.println(flag == false ? "Passport Details Not Available For Given Passport Number." : "Thank You For Using Our Application.");

    // * Better Approach For Same Application
    Passport passport = passportDB.get(enteredPassportID);
    if (passport != null) {
      System.out.println("Your Passport Details Are Given Below");
      System.out.println(passport);
      System.out.println("Thank You For Using Our Application.");
    } else {
      System.out.println("Passport Details Not Available For Given Passport Number.");
    }
    sc.close();
  }
};