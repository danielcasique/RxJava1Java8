package org.casique.ps.rxjava8.module3;

import java.util.concurrent.TimeUnit;
import org.casique.ps.rxjava8.util.ThreadUtils;
import org.casique.ps.rxjava8.util.TimeTicker;

public class BufferExample {

  public static void main(String[] args) {
    TimeTicker ticker = new TimeTicker(100);
    ticker.start();

    ticker.toObservable()
        .buffer(1, TimeUnit.SECONDS)
        .subscribe(list -> {
          System.out.println("------------------------------------------------------------");
          int count = 1;
          int size = list.size();
          for(int i = 0; i<size; i++){
            System.out.println("" + (count++) + ": " + list.get(i));
          }
        });

    ThreadUtils.sleep(5000);
    ticker.stop();
  }

}
