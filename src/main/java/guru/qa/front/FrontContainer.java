package guru.qa.front;

import guru.qa.session.Session;

public class FrontContainer implements Frontend {

  private final Frontend[] frontends;

  public FrontContainer(Frontend... frontends) {
    this.frontends = frontends;
  }

  @Override
  public void render(Session session) {
    for (Frontend frontend : frontends) {
      frontend.render(session);
    }
  }
}
