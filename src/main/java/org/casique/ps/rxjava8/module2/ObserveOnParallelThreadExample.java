package org.casique.ps.rxjava8.module2;

import java.util.List;
import org.casique.ps.rxjava8.util.ThreadUtils;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ObserveOnParallelThreadExample {

  public static void main(String[] args) {

    Object waitMonitor = new Object();
    synchronized (waitMonitor) {
      System.out.println(
          "---------------------------------------------------------------------------------");
      System.out.println(
          "Creating an observable that does not specify a subscribe or an observeOn schedule");
      System.out.println("driving thread " + Thread.currentThread().getName());
      System.out.println(
          "---------------------------------------------------------------------------------");

      List<Integer> fibonacciList = List.of(1, 2, 3, 5, 8, 13, 21, 34);

      Observable<Integer> observable = Observable.from(fibonacciList);

      observable
          // We want the subscriber driving code on a new thread.
          .subscribeOn(Schedulers.newThread())
          // We want to run this code in parallel
          .parallel((a) -> {

                // Create a filter that allows only even numbers to pass...
                return a
                    .filter((i) -> {
                      return i % 2 == 0;
                    })
                    .doOnNext((xx) -> {
                      System.out.println("parallel thread in: " + ThreadUtils.currentThreadName());
                      System.out.println("parallel: " + xx);
                      ThreadUtils.sleep(10); // Add a sleep to make sure we have a chance to see
                      // that the even number filter is executing in parallel.
                      System.out.println("parallel thread out: " + ThreadUtils.currentThreadName());
                    });
              },
              Schedulers.io()
          )
          .subscribe(
              // onNext function
              (i) -> {
                System.out.println("onNext thread entr: " + ThreadUtils.currentThreadName());
                System.out.println(i);
                System.out.println("onNext thread exit: " + ThreadUtils.currentThreadName());
              },
              // onError function
              (t) -> {
                t.printStackTrace();
              },
              // onCompleted
              () -> {
                System.out.println("onCompleted()");

                // Since we have completed...we sync on the waitMonitor
                // and then call notify to wake up the "main" thread.
                synchronized (waitMonitor) {
                  waitMonitor.notify();
                }
              }
          );
      ThreadUtils.wait(waitMonitor);
    }
  }
}

