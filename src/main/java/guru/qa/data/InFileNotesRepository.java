package guru.qa.data;

import com.opencsv.CSVReader;
import guru.qa.domain.Note;
import guru.qa.domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InFileNotesRepository implements NoteRepository {

  private final Path pathToFile;

  public InFileNotesRepository(Path pathToFile) {
    this.pathToFile = pathToFile;
  }

  @Override
  public List<Note> notesByUser(User user) {
    try (InputStream is = Files.newInputStream(pathToFile);
        CSVReader reader = new CSVReader(new InputStreamReader(is))) {

      return reader.readAll().stream()
          .filter(arr -> user.isLoginSame(arr[0]))
          .map(arr -> new Note(arr[0], arr[1]))
          .toList();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Note> allNotes() {
    try (InputStream is = Files.newInputStream(pathToFile);
        CSVReader reader = new CSVReader(new InputStreamReader(is))) {

      return reader.readAll().stream()
          .map(arr -> new Note(arr[0], arr[1]))
          .toList();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void saveNote(Note note) {
    try {
      Files.write(pathToFile, note.toString().getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
