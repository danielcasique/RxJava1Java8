package org.casique.ps.rxjava8.module2;

import org.casique.ps.rxjava8.util.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;

public class CompositionExample {

  public static void main(String[] args) {
    Object waitMonitor = new Object();
    synchronized (waitMonitor){
      UserService userService = new UserService();
      System.out.println("{\"userList\" : [ ");
      Observable.from(userService.fetchUserList())
          .parallel((userObservable) -> {
            return userObservable.filter((user) -> {
              return !UserSecurityStatus.Administrator.equals(user.getUserSecurityStatus());
            });
          })
          .toSortedList( (user1, user2) -> {
            return user1.getUserSecurityStatus().compareTo(user2.getUserSecurityStatus());
          })
          .subscribeOn(Schedulers.io())
          .doOnCompleted(() -> {
            synchronized (waitMonitor){
              waitMonitor.notify();
            }
          })
          .subscribe(
              (userList) -> {
                userList.forEach((user) -> {
                  System.out.println(user.toJSON());
                });
              }
          );
      ThreadUtils.wait(waitMonitor);
      System.out.println("] }");
    }
  }

}
