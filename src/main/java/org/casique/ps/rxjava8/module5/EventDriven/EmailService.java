package org.casique.ps.rxjava8.module5.EventDriven;

import java.util.List;

public interface EmailService {
  void sendEmail(List<String> recipienList, String fromEmail, String subject, String text);
}
