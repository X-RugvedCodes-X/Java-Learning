package com.rugved.datetimeapi;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;


@SuppressWarnings("unused")
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
    // LocalDate date = LocalDate.now();
    // System.out.println(date);             // * 2026-01-09
    // int dayOfMonth  = date.getDayOfMonth();
    // System.out.println(dayOfMonth);       // * 9
    // int dayOfYear   = date.getDayOfYear();  
    // System.out.println(dayOfYear);        // * 9
    // System.out.println(date.getMonthValue());   // * 1
    // System.out.println(date.getYear());         // * 2026

    // LocalDate dateOfBirth = LocalDate.of(2004, 11, 14);
    // System.out.println(dateOfBirth);      // * 2004-11-14

    // seperator();

    // LocalTime time = LocalTime.now();
    // System.out.println(time);
    // int hour = time.getHour();
    // int seconds = time.getSecond();
    // int minutes = time.getMinute();
    // int nanoseconds = time.getNano();
    // System.out.println(hour + ":" + minutes + ":" + seconds + ":" + nanoseconds);     // * 10:43:22:435695800
    
    // LocalDateTime timeDate = LocalDateTime.now();
    // System.out.println(timeDate);     // * 2026-01-09T10:49:18.765276600


    // ^ Summary 
    // * Use Joda API - now() and of() method, other ways of Date from util and sql are either deprecated or not recommended

    // ***********************************************************************************

    // LocalDate now = LocalDate.now();    
    // System.out.println(now);      // * 2026-01-26
    // LocalDate myDate = LocalDate.of(2004, 11, 14);
    // System.out.println(myDate);   // * 2004-11-14

    // int dayOfMonth = now.getDayOfMonth();
    // Month month = now.getMonth();
    // int year = now.getYear();
    // System.out.println(dayOfMonth);   // * 26
    // System.out.println(month);        // * JANUARY
    // System.out.println(year);         // * 2026

    // LocalDate today = LocalDate.now();
    // System.out.println(today);              // * 2026-01-26
    // LocalDate yesterday = today.minusDays(1); 
    // System.out.println(yesterday);          // * 2026-01-25
    // LocalDate pastTwoMonthsDate = today.minusMonths(2);
    // System.out.println(pastTwoMonthsDate);  // * 2025-11-26

    // if(today.isAfter(pastTwoMonthsDate))
    //   System.out.println("Yes");
    // * Above one Prints Yes

    // LocalTime now = LocalTime.now();
    // System.out.println(now);                  // * 22:34:56.944362900
    // LocalTime customTime = LocalTime.of(12, 22, 56);
    // System.out.println(customTime);           // * 12:22:56
    // String timeInString = "15:30:45";
    // LocalTime parsedTime = LocalTime.parse(timeInString);
    // System.out.println(parsedTime);           // * 15:30:45

    // LocalDateTime now = LocalDateTime.now();
    // System.out.println(now);                  // * 2026-01-26T22:51:48.046339200
    // LocalDateTime myDateTime = LocalDateTime.parse("2025-01-11T13:54");
    // System.out.println(myDateTime);           // * 2025-01-11T13:54

    // ZonedDateTime now = ZonedDateTime.now();
    // System.out.println(now);                  // * 2026-01-26T23:01:19.631113600+05:30[Asia/Calcutta]
    // Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    // System.out.println(availableZoneIds.size());      // * 604
    // availableZoneIds.forEach(System.out::println);

    // ZonedDateTime indianTime = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
    // System.out.println(indianTime);           // * 2026-01-26T23:06:14.061375100+05:30[Asia/Calcutta]
    // ZonedDateTime THE_USATime = ZonedDateTime.now(ZoneId.of("America/New_York"));
    // System.out.println(THE_USATime);          // * 2026-01-26T12:36:14.063361600-05:00[America/New_York]

    // Instant start = Instant.now();
    // int sum = 0;
    // for(int i = 0; i < 10000000; ++i) {
    //   sum += i + 1; 
    // }
    // Instant end = Instant.now();
    // Duration d1 = Duration.between(start, end);
    // System.out.println(d1);       // * PT0.0010015S
    // System.out.println(d1.toSeconds());

    // Instant start = Instant.now();
    // try {
    //   Thread.sleep(3000);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // Instant end = Instant.now();
    // Duration d = Duration.between(start, end);
    // System.out.println(d.toSeconds());    // * 3

    // LocalDate now = LocalDate.now();
    // LocalDate then = LocalDate.of(2004, 11, 14);
    // Period p = Period.between(now, then);
    // System.out.println(p);      // * P-21Y-2M-12D

    // ^ DateTime Formatter
    // LocalDate localDate = LocalDate.now();
    // DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // String format = localDate.format(myFormatter);
    // System.out.println(format);

    // String date = "25/04/2003";
    // DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
    // System.out.println(localDate);      // * 2003-04-25

    String dateTime = "2022-04-23 10:30:32+05:30";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
    ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime, formatter);
    System.out.println(zonedDateTime);    // * 2022-04-23T10:30:32+05:30
  }

  private static void seperator() {
    System.out.println("*".repeat(65));
  }
};