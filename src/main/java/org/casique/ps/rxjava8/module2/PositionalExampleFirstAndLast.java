package org.casique.ps.rxjava8.module2;

import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;

public class PositionalExampleFirstAndLast {

  public static void main(String[] args) {
    Observable.from(DataGenerator.generateGreekAlphabet())
        .first()
        .subscribe((letter) -> {
          System.out.println(letter);
        });
    System.out.println();

    Observable.from(DataGenerator.generateGreekAlphabet())
        .take(4)
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateGreekAlphabet())
        .last()
        .subscribe(letter -> System.out.println(letter));
    System.out.println();

    Observable.from(DataGenerator.generateGreekAlphabet())
        .takeLast(4)
        .subscribe(System.out::println);
    System.out.println();

    Observable.empty()
        .firstOrDefault("List is empty!")
        .subscribe(System.out::println);
    System.out.println();

    Observable.empty()
        .lastOrDefault("List is empty!")
        .subscribe(System.out::println);
    System.out.println();

  }

}
