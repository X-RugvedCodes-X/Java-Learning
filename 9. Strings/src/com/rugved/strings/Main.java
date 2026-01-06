package com.rugved.strings;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    // * Ways to Compare Strings
    // * 1. == operator
    // * 2. equals()
    // * 3. compareTo()
    // * 4. equalsIgnoreCase() and so on...

    // ^ Very Important Interview Question
    // String str1 = "Rugved";
    // String str2 = "Rugved";
    // System.out.println(str1 == str2);   // * true -  As both variables refer to same object in the String Constant Pool

    // String str1 = new String("Rugved");
    // String str2 = new String("Rugved");
    // System.out.println(str1 == str2);   // * false - The Strings "Rugved" is stored on the Heap Area two times, though one copy will be there in String Constant pool but address is returned only if the object is created as literal and not with the help of new keyword.

    // * == operator - even compares the reference, that's the reason above expressions prints false.
    // * .equals() - compares lexicographically only, that's the reason below expression prints true.
    // System.out.println(str1.equals(str2));  // * true

    // String str1 = "Rugved";
    // String str2 = "rugved";
    // System.out.println(str1 == str2);                 // * false
    // System.out.println(str1.equals(str2));            // * false
    // System.out.println(str1.equalsIgnoreCase(str2));  // * true - equalsIgnoreCase ignores case sensitivity.

    // String str1 = "Rugved";
    // System.out.println(str1);
    // str1.concat(" Raorane");
    // System.out.println(str1);   // * Now Also Rugved is printed because though the concat has created the object Rugved Raorane, the str1 is still refering to Rugved (the original one), So which means currently there are two objects in the SCP. Existing String object will not be changed instead new object created, hence Strings are immutable.
    // str1 = str1.concat(" Raorane");
    // System.out.println(str1);   // * Now we get output as expected
    // * String objects in the SCP are the last to be collected and released by the Garbage Collector.
    //^ Anytime String is created One Copy is always there on String Constant Pool
    // ********************************************************************************************************************* //

    // ^ Whenever reference variables are used to create new strings and even new keyword is not used, the string object are created on Heap, though one copy is there in SCP too.
    // String s1 = "Rugved";                       // * On SCP 
    // String s2 = s1.concat(" Raorane");          // * On Heap Area, though one copy in SCP will be made.
    // String s3 = "Rugved Raorane";               // * This is in the SCP as no new keyword or reference variables are involved.
    // System.out.println(s2 == s3);               // * Gives False as one is refering to the Heap and one to the SCP and as we know == operator even checks reference variables
    // String s4 = s1 + s2;                        // * On Heap Area, though one copy in SCP will be made.
    // System.out.println(s1);
    // System.out.println(s2);
    // System.out.println(s4);

    // * Difference between + and concat is that we can add as many strings using + operator and concat does only two
    // String s1 = "Java " + "Spring Boot " + "Microservices.";    // * Memeory Created in SCP as no reference variable or new keyword involved 
    // System.out.println(s1);

    // String s1 = "SpringBoot " + 2500 + 3900 + 4500;
    // System.out.println(s1);    // * SpringBoot 250039004500

    // String s2 = 45 + 44 + " SpringBoot";
    // System.out.println(s2);    // * 89 SpringBoot

    // String s3 = "SpringBoot " + (2500 + 3900 + 4500);
    // System.out.println(s3);    // * SpringBoot 10900

    // String str = "RugvedRaorane";
    // System.out.println(str.length());
    // System.out.println(str.toUpperCase());
    // System.out.println(str.toLowerCase());
    // System.out.println(str.substring(6, 9));      // * Rao
    // System.out.println(str.substring(6));                   // * Raorane

    // char ch[] = str.toCharArray();
    // for (char c : ch) {
    //   System.out.print(c + " ");
    // }
    // System.out.println();
    // System.out.println(str.charAt(4));              // * e
    // System.out.println(str.contains("Rao"));            // * true
    // System.out.println(str.startsWith("Rugv"));    // * true
    // System.out.println(str.indexOf("e"));             // * 4
    // System.out.println(str.lastIndexOf("e"));         // * 12

    // ********************************* One Last ****************************************** //
    // String str1 = "Rugved";     // * Object is in the SCP
    // str1 = str1 + " Raorane";   // * Object is on the Heap area as reference variable is involved, though one copy in SCP 

    // SomeOtherStringMethods.someOtherStringMethods();
    MutableStrings.main(new String[0]);
  }
};