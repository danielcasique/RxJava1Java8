package org.casique.ps.rxjava8.module1;

import java.util.Optional;
import java.util.function.Function;

public class FirstClassCitizenParameterIllustration {

  public static void main(String[] args) {
    System.out.println(concatAndTransform("Hello ", " World", Optional.of((s) -> {
      return s.toUpperCase();
    })));

    Function<String, String> transformToLower = (s) -> {
      return s.toLowerCase();
    };
    System.out.println(concatAndTransform("Hello ", " World", Optional.ofNullable(transformToLower)));
  }

  public static String concatAndTransform(String a, String b, Optional<Function<String, String>> stringTransform){
    if(stringTransform.isPresent()){
      a = stringTransform.get().apply(a);
      b = stringTransform.get().apply(b);
    }
    return a + b;
  }

}
