package org.casique.ps.rxjava8.module2;

import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;

public class PositionalExampleElementAt {

  public static void main(String[] args) {
    Observable.from(DataGenerator.generateGreekAlphabet())
        .elementAt(2)
        .subscribe(System.out::println);
    System.out.println();

    Observable.from(DataGenerator.generateGreekAlphabet())
        .elementAtOrDefault(50, "Unknown")
        .subscribe(System.out::println);
    System.out.println();
  }

}
