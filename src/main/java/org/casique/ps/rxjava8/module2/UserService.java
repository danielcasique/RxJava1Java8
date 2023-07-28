package org.casique.ps.rxjava8.module2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {

  private final List<User> allUsers;

  public UserService(){
    allUsers = List.of(new User("David", "david@test.com", UserSecurityStatus.Guest),
        new User("Ana", "ana@test.com", UserSecurityStatus.Moderator),
        new User("Roy", "roy@test.com", UserSecurityStatus.Administrator),
        new User("Lis", "lis@test.com", UserSecurityStatus.Guest),
        new User("Carlos", "carlos@test.com", UserSecurityStatus.Moderator));
  }

  public List<User> fetchUserList(){
    return Collections.unmodifiableList(allUsers);
  }
}
