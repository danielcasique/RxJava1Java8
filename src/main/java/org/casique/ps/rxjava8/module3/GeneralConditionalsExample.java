package org.casique.ps.rxjava8.module3;

import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;

public class GeneralConditionalsExample {

  public static void main(String[] args) {
    Observable.empty()
        .defaultIfEmpty("Hello Wordl")
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateGreekAlphabet())
        .defaultIfEmpty("Hello Wordl")
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateFibonacciList())
        .skipWhile(i -> i<8)
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateFibonacciList())
        .takeWhile(i -> i<8)
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateFibonacciList())
        .takeWhileWithIndex( (i, index) -> index < 3)
        .subscribe(System.out::println);
    System.out.println();
  }

}
