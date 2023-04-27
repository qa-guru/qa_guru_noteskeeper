package guru.qa.front;

import guru.qa.data.NoteRepository;
import guru.qa.domain.Note;
import guru.qa.session.Session;
import java.util.List;
import javax.swing.JOptionPane;

public class NotesFrontend implements Frontend {

  private final NoteRepository noteRepository;

  public NotesFrontend(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @Override
  public void render(Session session) {
    final String note = JOptionPane.showInputDialog("Note:");

    noteRepository.saveNote(
        new Note(
            session.getUser().getLogin(),
            note
        )
    );

    List<Note> notes = noteRepository.notesByUser(session.getUser());
    JOptionPane.showMessageDialog(null, notes.toString());
  }
}
