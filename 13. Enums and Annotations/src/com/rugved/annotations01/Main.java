package com.rugved.annotations01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class Main {
  // * Annotations are Kind of Meta Data, they are supplemental Information which we put in our Java Code, but can be processed by Compiler
  public static void main(String[] args) {
    Barbarian barbarian =  new Barbarian("Mike", 400);
    // if(barbarian.getClass().isAnnotationPresent(COCTroop.class)) 
    //   System.out.println("Yes, It's a COC Troop");
    // else 
    //   System.out.println("No, Not a COC Troop");
    // * Above Prints: Yes, It's a COC Troop

    // for(Method method : barbarian.getClass().getDeclaredMethods()) {
    //   if(method.isAnnotationPresent(AttackImmediately.class)) {
    //     AttackImmediately annotation = method.getAnnotation(AttackImmediately.class);
    //     for(int i = 0; i < annotation.times(); ++i) {
    //       try {
    //         method.invoke(barbarian);
    //       } catch (IllegalAccessException e) {
    //         e.printStackTrace();
    //       } catch (InvocationTargetException e) {
    //         e.printStackTrace();
    //       }
    //     }
    //   }
    // }
    
    for(Field field : barbarian.getClass().getDeclaredFields()) {
      if(field.isAnnotationPresent(ImportantField.class)) {
        Object objectValue = null;
        try {
          objectValue = field.get(barbarian);
        } catch (IllegalArgumentException | IllegalAccessException e) {
          e.printStackTrace();
        }
        if(objectValue instanceof String stringValue) {
          System.out.println(stringValue.toUpperCase());
        }
      }
    }
  }
}