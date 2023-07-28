package org.casique.ps.rxjava8.module5.EventDriven;

import rx.Observer;
import rx.util.functions.Action1;

public interface UserService {
  void addUser(String username, String emailAddress);
  void subscribeToUserEvents(Observer<UserEvent> subscriber);
  void subscribeToUserEvents(Action1<UserEvent> onNext);
}
