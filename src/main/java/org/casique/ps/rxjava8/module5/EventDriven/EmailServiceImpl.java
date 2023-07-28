package org.casique.ps.rxjava8.module5.EventDriven;

import java.util.List;

public class EmailServiceImpl implements EmailService{

  @Override
  public void sendEmail(List<String> recipienList, String fromEmail, String subject, String text) {
    System.out.println();
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("Sending email");
    System.out.println("-----------------------------------------------------------------------");
    System.out.print("To: ");
    recipienList.forEach(System.out::print);
    System.out.println();
    System.out.println("From: " + fromEmail);
    System.out.println("Subject: " + subject);
    System.out.println("Text: ");
    System.out.println();
    System.out.println(text);
    System.out.println();
    System.out.println("------------------------------------------------------------------------");
  }
}
