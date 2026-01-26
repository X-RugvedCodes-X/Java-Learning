package com.rugved.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
  public static boolean checkStringAgainstRE(String regularExpression, String str) {
    Pattern pattern = Pattern.compile(regularExpression);
    Matcher matcher = pattern.matcher(str);
    boolean answer  = matcher.matches();
    return answer;
  }
}
