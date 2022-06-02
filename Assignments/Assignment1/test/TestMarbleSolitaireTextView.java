import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.MockMarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Test methods for rendering the board and messages.
 */
public class TestMarbleSolitaireTextView {
  private EnglishSolitaireModel model1;
  private EnglishSolitaireModel model2;
  private MarbleSolitaireView view1;
  private MarbleSolitaireView view2;
  private MarbleSolitaireView view3;
  private MarbleSolitaireView view4;
  private MarbleSolitaireView winView;
  private MarbleSolitaireView loseView;

  @Before
  public void init() {
    model1 = new EnglishSolitaireModel();
    model2 = new EnglishSolitaireModel(3, 1);
    EnglishSolitaireModel model3 = new EnglishSolitaireModel(5);
    EnglishSolitaireModel model4 = new EnglishSolitaireModel(3, 3, 5);
    EnglishSolitaireModel win = new EnglishSolitaireModel(3);
    EnglishSolitaireModel lose = new EnglishSolitaireModel();

    view1 = new MarbleSolitaireTextView(model1);
    view2 = new MarbleSolitaireTextView(model2);
    view3 = new MarbleSolitaireTextView(model3);
    view4 = new MarbleSolitaireTextView(model4);
    winView = new MarbleSolitaireTextView(win);
    loseView = new MarbleSolitaireTextView(lose);


    win.move(3, 1, 3, 3);
    win.move(5, 2, 3, 2);
    win.move(4, 0, 4, 2);
    win.move(4, 3, 4, 1);
    win.move(4, 5, 4, 3);
    win.move(6, 4, 4, 4);
    win.move(3, 4, 5, 4);
    win.move(6, 2, 6, 4);
    win.move(6, 4, 4, 4);
    win.move(2, 2, 4, 2);
    win.move(0, 2, 2, 2);
    win.move(1, 4, 3, 4);
    win.move(3, 4, 5, 4);
    win.move(5, 4, 5, 2);
    win.move(5, 2, 3, 2);
    win.move(3, 2, 1, 2);
    win.move(2, 0, 4, 0);
    win.move(4, 0, 4, 2);
    win.move(4, 2, 4, 4);
    win.move(2, 6, 2, 4);
    win.move(2, 3, 2, 5);
    win.move(4, 6, 2, 6);
    win.move(2, 6, 2, 4);
    win.move(0, 4, 0, 2);
    win.move(0, 2, 2, 2);
    win.move(2, 1, 2, 3);
    win.move(2, 3, 2, 5);
    win.move(2, 5, 4, 5);
    win.move(4, 5, 4, 3);
    win.move(4, 3, 2, 3);
    win.move(1, 3, 3, 3);

    lose.move(1, 3, 3, 3);
    lose.move(4, 3, 2, 3);
    lose.move(3, 1, 3, 3);
    lose.move(3, 4, 3, 2);
    lose.move(3, 6, 3, 4);
    lose.move(6, 3, 4, 3);
  }

  @Test
  public void testConstructor() {
    try {
      EnglishSolitaireModel model = null;
      MarbleSolitaireView view = new MarbleSolitaireTextView(model);
      fail("Should throw IllegalArgument");
    } catch (IllegalArgumentException e) {
      assertEquals("game is null", e.getMessage());
    }

    try {
      Appendable appendable = null;
      MarbleSolitaireView view = new MarbleSolitaireTextView(model1, appendable);
      fail("Should throw Illegal Argument");
    } catch (IllegalArgumentException e) {
      assertEquals("null parameters", e.getMessage());
    }

    try {
      EnglishSolitaireModel model = null;
      Appendable appendable = new StringBuilder();
      MarbleSolitaireView view = new MarbleSolitaireTextView(model, appendable);
      fail("Should throw Illegal Argument");
    } catch (IllegalArgumentException e) {
      assertEquals("null parameters", e.getMessage());
    }
  }


  @Test
  public void testToString() {
    assertEquals("    O O O" +
                    "\n    O O O" +
                    "\nO O O O O O O" +
                    "\nO O O _ O O O" +
                    "\nO O O O O O O" +
                    "\n    O O O" +
                    "\n    O O O",
            view1.toString());
    assertEquals("    O O O" +
                    "\n    O O O" +
                    "\nO O O O O O O" +
                    "\nO _ O O O O O" +
                    "\nO O O O O O O" +
                    "\n    O O O" +
                    "\n    O O O",
            view2.toString());
    assertEquals("        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O _ O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O",
            view3.toString());
    assertEquals("    O O O" +
                    "\n    O O O" +
                    "\nO O O O O O O" +
                    "\nO O O O O _ O" +
                    "\nO O O O O O O" +
                    "\n    O O O" +
                    "\n    O O O",
            view4.toString());

    assertEquals("    _ _ _" +
                    "\n    _ _ _" +
                    "\n_ _ _ _ _ _ _" +
                    "\n_ _ _ O _ _ _" +
                    "\n_ _ _ _ _ _ _" +
                    "\n    _ _ _" +
                    "\n    _ _ _",
            winView.toString());
    assertEquals("    O O O" +
                    "\n    O _ O" +
                    "\nO O O O O O O" +
                    "\nO _ O _ O _ _" +
                    "\nO O O O O O O" +
                    "\n    O _ O" +
                    "\n    O _ O",
            loseView.toString());
  }

  @Test
  public void testRenderBoard() {
    Appendable appendable = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model1, appendable);
    try {
      view.renderBoard();
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    assertEquals("    O O O" +
            "\n    O O O" +
            "\nO O O O O O O" +
            "\nO O O _ O O O" +
            "\nO O O O O O O" +
            "\n    O O O" +
            "\n    O O O" +
            "\n", appendable.toString());

    Reader reader = new StringReader("4 2 4 4 2 3 4 3 q");
    appendable = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model1, appendable);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(model1, view2, reader);
    controller.playGame();
    assertTrue(appendable.toString().contains("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 31\n"
            + "    O O O\n"
            + "    _ O O\n"
            + "O O _ O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 30\n"));


    String quitMessage = "Game quit!\n"
            + "State of game when quit:\n"
            + "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O _ O O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O\n"
            + "Score: 32\n";
    Reader reader2 = new StringReader("q");
    StringBuilder appendable2 = new StringBuilder();
    view2 = new MarbleSolitaireTextView(model2, appendable2);
    controller = new MarbleSolitaireControllerImpl(model2, view2, reader2);
    controller.playGame();
    assertTrue(appendable2.toString().contains(quitMessage));

    Reader reader3 = new StringReader("3 q");
    StringBuilder appendable3 = new StringBuilder();
    view3 = new MarbleSolitaireTextView(model2, appendable3);
    controller = new MarbleSolitaireControllerImpl(model2, view3, reader3);
    controller.playGame();
    assertTrue(appendable3.toString().contains(quitMessage));

    Reader reader4 = new StringReader("3 3 q 2");
    StringBuilder appendable4 = new StringBuilder();
    view4 = new MarbleSolitaireTextView(model2, appendable4);
    controller = new MarbleSolitaireControllerImpl(model2, view4, reader4);
    controller.playGame();
    assertTrue(appendable4.toString().contains(quitMessage));
  }

  @Test
  public void testRenderMessage() {
    StringBuilder appendable = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(model1, appendable);
    try {
      view.renderMessage("test1\n");
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    assertEquals("test1\n", appendable.toString());

    StringBuilder appendable2 = new StringBuilder();
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(model1, appendable2);
    try {
      view2.renderMessage("test2.1\n");
      view2.renderMessage("test2.2\n");
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
    assertEquals("test2.1\ntest2.2\n", appendable2.toString());

    StringBuilder appendable3 = new StringBuilder();
    Readable readable = new StringReader("-1 q");
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(model1, appendable3);
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model1,
            view3, readable);
    controller.playGame();
    assertTrue(appendable3.toString().contains("Invalid input, Please enter new one\n"));
  }

  @Test
  public void testIOException() {
    StringBuilder appendable = new StringBuilder();
    MarbleSolitaireView corruptView = new MockMarbleSolitaireTextView(appendable);
    try {
      corruptView.renderBoard();
      fail("Should throw IO exception");
    } catch (IOException e) {
      assertEquals("IOException", e.getMessage());
    }

    StringBuilder appendable2 = new StringBuilder();
    MarbleSolitaireView corruptView2 = new MockMarbleSolitaireTextView(appendable2);
    try {
      corruptView2.renderMessage("test\n");
      fail("Should throw IOException");
    } catch (IOException e) {
      assertEquals("IOException", e.getMessage());
    }
  }
}