package com.rugved.arrays;

public class StringBasics {
  public static void main(String[] args) {
    // String series = "";

    // for (int i = 0; i < 26; ++i) {
    //   char ch = (char)('a' + i);
    //   series += ch;
    // }

    // System.out.println(series);

    // String name = "Rugved Raorane Learns Java";
    // System.out.println(Arrays.toString(name.toCharArray()));       //* [R, u, g, v, e, d,  , R, a, o, r, a, n, e,  , L, e, a, r, n, s,  , J, a, v, a] */
    // System.out.println(name.toLowerCase());                        //* rugved raorane learns java (Creates a new Object original does not change)*/
    // System.out.println(name);                                      //* Rugved Raorane Learns Java */
    // System.out.println(name.indexOf('v'));
    // System.out.println("             Rugved   ".strip());
    // System.out.println("             Rugved   ".trim());
    // System.out.println(Arrays.toString(name.split(" ")));          //* [Rugved, Raorane, Learns, Java] */

    String str1 = "";
    String str2 = null;
    String str3 = "Appa";
    String str4 = "abcdcba";

    System.out.println(isPalindrome(str1) ? "Palindrome" : "Not A Palindrome");
    System.out.println(isPalindrome(str2) ? "Palindrome" : "Not A Palindrome");
    System.out.println(isPalindrome(str3) ? "Palindrome" : "Not A Palindrome");
    System.out.println(isPalindrome(str4) ? "Palindrome" : "Not A Palindrome");
  }

  static boolean isPalindrome(String str) {
    if (str == null || str.length() == 0)
      return true; 

    str = str.toLowerCase();
    for (int i = 0; i <= str.length() / 2; ++i) {
      char start = str.charAt(i), end = str.charAt(str.length() - i - 1);
      if (start != end) 
        return false;
    }
    return true;
  }
};