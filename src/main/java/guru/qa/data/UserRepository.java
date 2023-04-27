package guru.qa.data;

import guru.qa.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

  List<User> allUsers();

  Optional<User> userByLogin(String login);

}
