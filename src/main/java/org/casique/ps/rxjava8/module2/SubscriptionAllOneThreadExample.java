package org.casique.ps.rxjava8.module2;

import java.util.List;
import java.util.concurrent.Executors;
import rx.Observable;

public class SubscriptionAllOneThreadExample {

  public static void main(String[] args) {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("Creating an observable that does not specify a subscribe or an observeOn schedule");
    System.out.println("driving thread " + Thread.currentThread().getName());
    System.out.println("---------------------------------------------------------------------------------");

    List<Integer> fibonacciList = List.of(1, 2, 3, 5, 8,13, 21, 34);
    Observable<Integer> observable = Observable.from(fibonacciList);

    observable
        .subscribe(
        //onNext function
        (i) ->{
          System.out.println("OnNext thread entry: " + Thread.currentThread().getName());
          System.out.println(i);
          System.out.println("OnNext thread exit: " + Thread.currentThread().getName());
        },
        //onError functon
        (t) -> {
          t.printStackTrace();
        },
        //onComplete
        () -> {
          System.out.println("onComplete()");
        }
      );
  }

}
