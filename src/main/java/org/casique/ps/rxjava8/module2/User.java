package org.casique.ps.rxjava8.module2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private String name;
  private String email;
  private UserSecurityStatus userSecurityStatus;

  public String toJSON() {

    return "    { 'username' : \"" + name + "\", "
        + " 'emailAddress' : \"" + email + "\","
        + " 'securityStatus' : \"" + userSecurityStatus.toString() + "\"},";
  }
}
