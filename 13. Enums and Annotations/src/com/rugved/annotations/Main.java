package com.rugved.annotations;

import java.text.Annotation;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, annotations");
    
    // * Using Reflection API to Fetch the Data inside of the Annotations
    Barbarian barbarian = new Barbarian();
    barbarian.setHitpoints(300);
    System.out.println(barbarian.getHitpoints());

    seperator();

    Class<? extends Barbarian> b = barbarian.getClass();
    COC_Troop cocTroop = b.getAnnotation(COC_Troop.class);
    // Annotation cocTroop = b.getAnnotation(COC_Troop.class);
    // COC_Troop troop = (COC_Troop)cocTroop;    // * DownCasting
    int damage = cocTroop.damage();     // * Reading Values of Annotation
    String type = cocTroop.type();
    System.out.println("Information of Attributes of Annotations are -> Damage: " + damage + ", Type: " + type);
  } 

  private static void seperator() {
    System.out.println("*".repeat(65));
  }
};