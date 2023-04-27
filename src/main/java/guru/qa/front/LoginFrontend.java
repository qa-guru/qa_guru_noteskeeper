package guru.qa.front;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

import guru.qa.data.UserRepository;
import guru.qa.domain.User;
import guru.qa.session.Session;
import java.util.Objects;
import java.util.Optional;
import javax.swing.JOptionPane;

public class LoginFrontend implements Frontend {

  private final UserRepository userRepository;

  public LoginFrontend(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void render(Session session) {
    final String login = JOptionPane.showInputDialog("Login:");
    final String password = JOptionPane.showInputDialog("Password:");

    Optional<User> user = userRepository.userByLogin(login);
    User foundedUser = null;
    if (user.isEmpty()) {
      JOptionPane.showMessageDialog(null,
          "User not found",
          "Error",
          ERROR_MESSAGE
      );
      render(session);
    } else {
      foundedUser = user.get();
    }

    if (!Objects.requireNonNull(foundedUser)
        .isCredentialsAccept(login, password)) {
      JOptionPane.showMessageDialog(null,
          "Credentials are incorrect",
          "Error",
          ERROR_MESSAGE
      );
      render(session);
    }

    session.setUser(foundedUser);
  }
}
