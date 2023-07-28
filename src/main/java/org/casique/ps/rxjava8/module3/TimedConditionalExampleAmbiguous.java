package org.casique.ps.rxjava8.module3;

import org.casique.ps.rxjava8.util.DataGenerator;
import org.casique.ps.rxjava8.util.ThreadUtils;
import org.casique.ps.rxjava8.util.TimedEventSequence;
import rx.Observable;

public class TimedConditionalExampleAmbiguous {

  public static void main(String[] args) {
    TimedEventSequence<String> sequence1 = new TimedEventSequence<>(DataGenerator.generateGreekAlphabet(), 50);
    TimedEventSequence<String> sequence2 = new TimedEventSequence<>(DataGenerator.generateEnglishAlphabet(), 100);

    Observable.amb(sequence1.toObservable(), sequence2.toObservable())
        .subscribe(System.out::println);

    sequence1.start();
    sequence2.start();

    ThreadUtils.sleep(4000);

    sequence1.stop();
    sequence2.stop();
  }

}
