package cs3500.marblesolitaire.view;

import java.io.IOException;

/**
 * MockTextView that will throw errors.
 */
public class MockMarbleSolitaireTextView implements MarbleSolitaireView {
  StringBuilder a;

  /**
   * constructs a MockMarbleSolitaireTextView Object.
   * @param a : an appendable StringBuilder
   */
  public MockMarbleSolitaireTextView(StringBuilder a) {
    this.a = a;
  }

  @Override
  public void renderBoard() throws IOException {
    throw new IOException("IOException");
  }

  @Override
  public void renderMessage(String message) throws IOException {
    throw new IOException("IOException");
  }
}
