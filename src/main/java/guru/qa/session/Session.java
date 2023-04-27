package guru.qa.session;

import guru.qa.domain.User;

public class Session {

  private User user;

  public Session(User user) {
    this.user = user;
  }

  public Session() {

  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
