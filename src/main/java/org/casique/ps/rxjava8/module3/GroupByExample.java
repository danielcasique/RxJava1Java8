package org.casique.ps.rxjava8.module3;

import java.util.ArrayList;
import java.util.List;
import org.casique.ps.rxjava8.util.DataGenerator;
import rx.Observable;

public class GroupByExample {

  public static void main(String[] args) {

    Observable.from(DataGenerator.generateBigIntegerList())
        .groupBy(i -> i % 2 == 0 ? "Even" : "ODD")
        .subscribe(groupList -> {
          System.out.println("key " + groupList.getKey());
          groupList.subscribe(x -> System.out.println(groupList.getKey() + " : " + x));
        });
    System.out.println();

    List<Integer> even = new ArrayList<>();
    List<Integer> odd = new ArrayList<>();

    Observable.from(DataGenerator.generateBigIntegerList())
        .groupBy(i -> i % 2 == 0 ? "EVEN" : "ODD")
        .subscribe(groupList -> {
          groupList.subscribe( x -> {
            if(groupList.getKey().equals("EVEN"))
              even.add(x);
            else
              odd.add(x);
          });
        });
    System.out.println("even list");
    even.stream().forEach(System.out::println);
    System.out.println("odd list");
    odd.stream().forEach(System.out::println);
    System.out.println();

  }

}
