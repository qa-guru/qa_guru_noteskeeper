package guru.qa.domain;

public class User {

  private final String login;
  private final String password;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public boolean isLoginSame(String login) {
    return this.login.equals(login);
  }

  public boolean isPasswordSame(String password) {
    return this.password.equals(password);
  }

  public boolean isCredentialsAccept(String login, String password) {
    return isLoginSame(login) && isPasswordSame(password);
  }
}
