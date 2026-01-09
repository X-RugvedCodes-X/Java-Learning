package com.rugved.dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// import java.util.Date;
// import java.sql.Date;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    seperator();
    // * Whenever we want to use Date for normal operation we go for Date from util package
    // * Whenever we want to use Date for JDBC operationn then we go for Date from sql package
    // * Java 8 -> joda api = new date and time api which is in time package

    // Date date = new Date();
    // System.out.println(date);
    // int year = date.getYear();
    // System.out.println(year);
    // long timeInms = date.getTime();
    // System.out.println(timeInms);

    // long timeInms = 1767934866368L;
    // Date date = new Date(timeInms);     // * Mind you there is no zero parameter constructor in sql.Date
    // System.out.println(date);           // * 2026-01-09

    // * Joda API
    LocalDate date = LocalDate.now();
    System.out.println(date);             // * 2026-01-09
    int dayOfMonth  = date.getDayOfMonth();
    System.out.println(dayOfMonth);       // * 9
    int dayOfYear   = date.getDayOfYear();  
    System.out.println(dayOfYear);        // * 9
    System.out.println(date.getMonthValue());   // * 1
    System.out.println(date.getYear());         // * 2026

    LocalDate dateOfBirth = LocalDate.of(2004, 11, 14);
    System.out.println(dateOfBirth);      // * 2004-11-14

    seperator();

    LocalTime time = LocalTime.now();
    System.out.println(time);
    int hour = time.getHour();
    int seconds = time.getSecond();
    int minutes = time.getMinute();
    int nanoseconds = time.getNano();
    System.out.println(hour + ":" + minutes + ":" + seconds + ":" + nanoseconds);     // * 10:43:22:435695800
    
    LocalDateTime timeDate = LocalDateTime.now();
    System.out.println(timeDate);     // * 2026-01-09T10:49:18.765276600


    // ^ Summary 
    // * Use Joda API - now() and of() method, other ways of Date from util and sql are either deprecated or not recommended
  }

  private static void seperator() {
    System.out.println("*".repeat(65));
  }
};