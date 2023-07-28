package org.casique.ps.rxjava8.module2;

import java.util.concurrent.TimeUnit;
import org.casique.ps.rxjava8.util.ThreadUtils;
import org.casique.ps.rxjava8.util.TimeTicker;

public class TimedBasedExampleSample {

  public static void main(String[] args) {
    TimeTicker ticker = new TimeTicker(10);
    ticker.start();
    try{
      ticker.toObservable()
          .sample(1, TimeUnit.SECONDS)
          .subscribe(t -> System.out.println("Tick: " + t));
      ThreadUtils.sleep(10000);
    }finally {
      ticker.stop();
    }
  }
}
