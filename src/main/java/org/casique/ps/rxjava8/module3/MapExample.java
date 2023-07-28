package org.casique.ps.rxjava8.module3;

import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;

public class MapExample {

  public static void main(String[] args) {
    Observable.from(DataGenerator.generateGreekAlphabet())
        .map(letter -> letter.toUpperCase())
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateGreekAlphabet())
        .flatMap(letter -> {
          String[] returnString = {
              letter.toUpperCase(), letter.toLowerCase()
          };
          return Observable.from(returnString);
        })
        .subscribe(System.out::println);
  }

}
