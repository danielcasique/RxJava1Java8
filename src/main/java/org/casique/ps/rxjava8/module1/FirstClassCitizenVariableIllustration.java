package org.casique.ps.rxjava8.module1;

import java.util.function.BiFunction;

public class FirstClassCitizenVariableIllustration {

  public static void main(String[] args) {

    BiFunction<String, String, String> concatFunction = (s, t) -> {
      return s + t;
    };
    System.out.println(concatFunction.apply("Hello ", "World 1"));

    concatFunction = FirstClassCitizenVariableIllustration::concatStrings;
    System.out.println(concatFunction.apply("Hello ", "World 2"));

    FirstClassCitizenVariableIllustration instance = new FirstClassCitizenVariableIllustration();
    concatFunction = instance::concatString2;
    System.out.println(concatFunction.apply("Hello ", " World 3"));

  }
  private static String concatStrings(String a, String b){
    return a + b;
  }

  String concatString2(String a, String b){
    return a + b;
  }
}
