package org.casique.ps.rxjava8.module2;

import java.util.List;
import rx.Observable;

public class SimpleCreationExamples {

  public static void main(String[] args) {
    Observable<Integer> observable = null;
    System.out.println("---------------------------------------------------");
    System.out.println("Observable creation from a single value");
    System.out.println("----------------------------------------------------");
    observable = Observable.just(Integer.valueOf(42));
    observable.subscribe( (i) -> {
      System.out.println(i);
    });
    List<Integer> fibonacciList = List.of(1, 2, 3, 5, 8,13, 21, 34);
    System.out.println("---------------------------------------------------");
    System.out.println("Observable creation from an Iterable");
    System.out.println("----------------------------------------------------");
    observable = Observable.from(fibonacciList);
    observable.subscribe( (i) -> {
      System.out.println(i);
    });
    Integer[] fibonnaciArray = {1, 2, 3, 5, 8,13, 21, 34};
    System.out.println("---------------------------------------------------");
    System.out.println("Observable creation from an Array");
    System.out.println("----------------------------------------------------");
    observable = Observable.from(fibonnaciArray);
    observable.subscribe( (i) -> {
      System.out.println(i);
    });

  }

}
