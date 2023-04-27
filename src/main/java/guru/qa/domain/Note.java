package guru.qa.domain;

public class Note {

  private final String username;
  private final String text;

  public Note(String username, String text) {
    this.username = username;
    this.text = text;
  }

  public Note changeText(String newText) {
    return new Note(this.username, newText);
  }

  @Override
  public String toString() {
    return username + "," + text;
  }
}
