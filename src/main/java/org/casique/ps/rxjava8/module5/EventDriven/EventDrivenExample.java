package org.casique.ps.rxjava8.module5.EventDriven;

public class EventDrivenExample {

  public static void main(String[] args) {
    try {

      // Create an EmailService
      EmailService emailService = new EmailServiceImpl();

      // Create a UserService
      UserService userService = new UserServiceImpl();

      // Create an EmailMonitor...no need to track a reference.
      new EmailMonitor(emailService, userService);

      // Create a user...
      userService.addUser("relledge", "relledge@nosuchemail.com");

      // Wait for a few moments...
      Thread.sleep(2000);

      // Exit
      System.exit(0);

    } catch (Throwable t) {
      t.printStackTrace();
    }
  }

}
