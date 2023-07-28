package org.casique.ps.rxjava8.module5.EventDriven;

public class CreateUserEvent  extends UserEvent {

  public CreateUserEvent(String username, String emailAddress) {
    super(username, emailAddress);
  }

}