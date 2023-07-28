package org.casique.ps.rxjava8.module2;

import java.util.List;
import java.util.concurrent.FutureTask;
import rx.Observable;
import rx.schedulers.Schedulers;


public class FutureCreationExample {

  public static void main(String[] args) {
    Observable<List<Integer>> observableFutureList;
    List<Integer> fibonacciList = List.of(1, 2, 3, 5, 8,13, 21, 34);
    FutureTask<List<Integer>> future = new FutureTask<>( () -> fibonacciList);

    observableFutureList = Observable.from(future);

    Schedulers.computation().schedule((s) -> {
      future.run();
    });

    observableFutureList.subscribe( (list) -> {
      list.forEach((i) -> {
        System.out.println(i);
      });
    });


  }

}
