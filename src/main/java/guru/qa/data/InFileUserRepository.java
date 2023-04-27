package guru.qa.data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import guru.qa.domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class InFileUserRepository implements UserRepository {

  private final Path pathToFile;

  public InFileUserRepository(Path pathToFile) {
    this.pathToFile = pathToFile;
  }

  @Override
  public List<User> allUsers() {
    try (InputStream is = Files.newInputStream(pathToFile);
        CSVReader reader = new CSVReader(new InputStreamReader(is))) {

      return reader.readAll().stream()
          .map(arr -> new User(arr[0], arr[1]))
          .toList();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Optional<User> userByLogin(String login) {
    try (InputStream is = Files.newInputStream(pathToFile);
        CSVReader reader = new CSVReader(new InputStreamReader(is))) {

      String[] userSource = reader.readAll().stream()
          .filter(arr -> arr[0].equals(login))
          .findFirst()
          .orElse(null);

      return userSource != null
          ? Optional.of(new User(userSource[0], userSource[1]))
          : Optional.empty();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
