package org.casique.ps.rxjava8.module2;

import java.util.concurrent.TimeUnit;
import org.casique.ps.rxjava8.util.ThreadUtils;
import org.casique.ps.rxjava8.util.TimeTicker;

public class TimeBasedExampleTimeout {

  public static void main(String[] args) {
    TimeTicker ticket = new TimeTicker(100);
    ticket.start();

    try{
      ticket.toObservable()
          .timeout(3, TimeUnit.SECONDS)
          .subscribe((t) -> {
            System.out.println("tickt: " + t);
          },
              (exception) -> {
                System.out.println("Timeout!");
              });
      ThreadUtils.sleep(1000);
      System.out.println("Pausing ticker");
      ticket.pause();
      ThreadUtils.sleep(5000);

    }finally {
      ticket.stop();
    }
  }

}
