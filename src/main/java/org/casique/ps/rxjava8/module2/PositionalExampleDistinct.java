package org.casique.ps.rxjava8.module2;

import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;

public class PositionalExampleDistinct {

  public static void main(String[] args) {
    Observable.from(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
        .distinct()
        .subscribe(System.out::println);
    System.out.println();
  }
}
