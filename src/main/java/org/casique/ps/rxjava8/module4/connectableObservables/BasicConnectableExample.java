package org.casique.ps.rxjava8.module4.connectableObservables;

import org.casique.ps.rxjava8.util.ThreadUtils;
import org.casique.ps.rxjava8.util.TimeTicker;
import rx.observables.ConnectableObservable;

public class BasicConnectableExample {

  public static void main(String[] args) {
    TimeTicker ticker = new TimeTicker(500);
    ticker.start();

    ConnectableObservable<Long> connectableObservable = ticker.toObservable().publish();

    connectableObservable.subscribe(
        t -> System.out.println("tick: " + ThreadUtils.currentThreadName() + " " + t));

    System.out.println("Sleeping 3 sec");
    ThreadUtils.sleep(3000);

    System.out.println("Connecting");
    connectableObservable.connect();

    ThreadUtils.sleep(30000);
    System.out.println("3 sec are up!");

    ticker.stop();
  }

}
