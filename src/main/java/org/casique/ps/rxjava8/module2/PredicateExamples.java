package org.casique.ps.rxjava8.module2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import rx.Observable;

public class PredicateExamples {

  public static void main(String[] args) {
    List<Integer> range = IntStream.rangeClosed(0, 199)
        .boxed().collect(Collectors.toList());
    Observable.from(range)
        .filter((i) -> ((i%3==0)&&(i<20)))
        .subscribe((i) -> {
          System.out.println(i);
        });
  }

}
