package guru.qa.data;

import guru.qa.domain.Note;
import guru.qa.domain.User;
import java.util.List;

public interface NoteRepository {

  List<Note> notesByUser(User user);

  List<Note> allNotes();

  void saveNote(Note note);

}
