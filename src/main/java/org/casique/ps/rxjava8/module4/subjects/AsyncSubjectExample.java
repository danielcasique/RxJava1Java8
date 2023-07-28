package org.casique.ps.rxjava8.module4.subjects;

import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;

public class AsyncSubjectExample {

  public static void main(String[] args) {


    AsyncSubject<String> subject = AsyncSubject.create();

    subject.subscribe((letter) -> {
      System.out.println(letter);
    });

    Observable.from(DataGenerator.generateGreekAlphabet())
        .subscribe((letter) -> {
              subject.onNext(letter);
            },
            (t) -> {
              subject.onError(t);
            },
            () -> {
              System.out.println("Subscriber 1: onCompleted");
              subject.onCompleted();
            });


    subject.subscribe(
        (letter) -> {
          System.out.println("Subscriber 2: " + letter);
        },
        (t) -> {
          subject.onError(t);
        },
        () -> {
          System.out.println("Subscriber 2: onCompleted");
          subject.onCompleted();
        }
    );

  }

}
