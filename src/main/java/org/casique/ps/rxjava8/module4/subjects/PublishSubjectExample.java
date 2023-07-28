package org.casique.ps.rxjava8.module4.subjects;

import org.casique.ps.rxjava8.util.DataGenerator;
import org.casique.ps.rxjava8.util.ThreadUtils;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class PublishSubjectExample {

  public static void main(String[] args) {
    Object signal = new Object();
    synchronized (signal) {
      PublishSubject<String> subject = PublishSubject.create();

      subject.subscribe((letter) -> {
        System.out.println("subscriber 1: " + letter);
        ThreadUtils.sleep(500);
        if (letter.equals("Eta")) {
          synchronized (signal) {
            signal.notify();
          }
        }
      });

      Observable.from(DataGenerator.generateGreekAlphabet())
          .subscribeOn(Schedulers.computation())
          .subscribe((letter) -> {
                subject.onNext(letter);
              },
              (t) -> {
                subject.onError(t);
              },
              () -> {
                System.out.println("Subscriber 1: onCompleted");
                subject.onCompleted();
                synchronized (signal) {
                  signal.notify();
                }
              });

      ThreadUtils.wait(signal);

      subject.subscribe(
          (letter) -> {
            System.out.println("Subscriber 2: " + letter);
          },
          (t) -> {
            subject.onError(t);
          },
          () -> {
            System.out.println("Subscriber 2: onCompleted");
          }
      );

      ThreadUtils.wait(signal);

    }
  }

}
