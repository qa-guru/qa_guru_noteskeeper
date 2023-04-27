package guru.qa;

import guru.qa.data.InFileNotesRepository;
import guru.qa.data.InFileUserRepository;
import guru.qa.data.NoteRepository;
import guru.qa.front.FrontContainer;
import guru.qa.front.Frontend;
import guru.qa.front.LoginFrontend;
import guru.qa.front.NotesFrontend;
import guru.qa.session.Session;
import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {
    new FrontContainer(
        new LoginFrontend(
            new InFileUserRepository(
                Path.of("users.csv")
            )
        ),
        new NotesFrontend(
            new InFileNotesRepository(
                Path.of("notes.csv")
            )
        )
    ).render(
        new Session()
    );
  }
}