package org.casique.ps.rxjava8.module3;

import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;

public class ScanMap {

  public static void main(String[] args) {
    Observable.from(DataGenerator.generateGreekAlphabet())
        .scan(new StringBuilder(), (accumBuffer, nextLetter) -> {
          return accumBuffer.append(nextLetter);
        })
        .subscribe(total -> System.out.println("Scan Event: " + total.toString()));
    System.out.println();

    Observable.from(DataGenerator.generateGreekAlphabet())
        .scan(new StringBuilder(), (accumBuffer, nextLetter) -> {
          return accumBuffer.append(nextLetter);
        })
        .last()
        .subscribe(total -> System.out.println("Scan Event: " + total.toString()));
    System.out.println();
  }

}
