package org.casique.ps.rxjava8.module3;

import org.casique.ps.rxjava8.util.DataGenerator;
import org.casique.ps.rxjava8.util.ThreadUtils;
import org.casique.ps.rxjava8.util.TimeTicker;
import org.casique.ps.rxjava8.util.TimedEventSequence;

public class TimedConditionalExampleSkipUntil {

  public static void main(String[] args) {
    TimedEventSequence<String> sequence1 = new TimedEventSequence<>(DataGenerator.generateGreekAlphabet(), 50);
    TimeTicker ticker = new TimeTicker(3000);

    sequence1.toObservable()
        .skipUntil(ticker.toObservable())
        .subscribe(System.out::println);

    ticker.start();
    sequence1.start();

    ThreadUtils.sleep(6000);

    sequence1.stop();
    ticker.stop();
  }

}
