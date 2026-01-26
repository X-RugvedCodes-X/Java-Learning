package com.rugved.regex;

import java.util.regex.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, regex");

    // * First Create and Compile our pattern, then match with a string and use .matches which will tell if the string matches the pattern or not
    // Pattern p = Pattern.compile("a*b");
    // Matcher m = p.matcher("aaaab");
    // boolean b = m.matches();
    // System.out.println(b);      // * true

    // * Example 1
    // String regex = "a*b";
    // String str = "aaab";
    // Pattern pattern = Pattern.compile(regex);
    // Matcher matcher = pattern.matcher(str);
    // boolean answer  = matcher.matches();
    // System.out.println("Result: " + answer);    // * true 

    // * Example 2
    // String regex = "a*b";
    // String str = "b";
    // Pattern pattern = Pattern.compile(regex);
    // Matcher matcher = pattern.matcher(str);
    // boolean answer  = matcher.matches();
    // System.out.println("Result: " + answer);    // * true

    // * Example 3
    // String regex = "a+b";    // * Atleast One a is compulsory
    // String str = "b";
    // Pattern pattern = Pattern.compile(regex);
    // Matcher matcher = pattern.matcher(str);
    // boolean answer  = matcher.matches();
    // System.out.println("Result: " + answer);    // ! false

    // * Example 4
    // String regex = "(a+b)*b";
    // String str = "aaab";
    // Pattern pattern = Pattern.compile(regex);
    // Matcher matcher = pattern.matcher(str);
    // boolean answer  = matcher.matches();
    // System.out.println("Result: " + answer);    // ! false

    // * Example 5
    // String regex = "a*b*";    // * Means any number of a followed by any number of b (Both can be zero too)
    // String str = "aaa";       // * Even empty can be true here
    // Pattern pattern = Pattern.compile(regex);
    // Matcher matcher = pattern.matcher(str);
    // boolean answer  = matcher.matches();
    // System.out.println("Result: " + answer);    // * true

    // ^ Some more Patterns
    // * X?       - X occurs once or not at all
    // * X*       - X occurs Zero or more times
    // * X+       - X occurs One or more times
    // * X{n}     - X occurs exactly n times
    // * X{n, }   - X occurs atleast n times
    // * X{n, m}  - X occurs atleast n but not more than m times
    // * XY       - X followed by Y
    // * X|Y      - Either X or Y

    Problem01.problem01();
  }
}
