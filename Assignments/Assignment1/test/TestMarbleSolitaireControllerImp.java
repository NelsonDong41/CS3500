import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MockEnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.MockMarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the controller implementation.
 */
public class TestMarbleSolitaireControllerImp {
  private StringBuilder out1;
  private MarbleSolitaireView view1;
  private MockEnglishSolitaireModel model1;
  private MarbleSolitaireController controller1;

  private StringBuilder out2;
  private MarbleSolitaireView view2;
  private MockEnglishSolitaireModel model2;
  private MarbleSolitaireController controller2;

  private StringBuilder out3;
  private MarbleSolitaireView view3;
  private MockEnglishSolitaireModel model3;
  private MarbleSolitaireController controller3;

  private StringBuilder out4;
  private MarbleSolitaireView view4;
  private MockEnglishSolitaireModel model4;
  private MarbleSolitaireController controller4;


  private StringBuilder out5;
  private MarbleSolitaireView view5;
  private MockEnglishSolitaireModel model5;

  private StringBuilder out6;
  private MarbleSolitaireView view6;
  private EnglishSolitaireModel model6;
  private MarbleSolitaireController controller6;
  private StringBuilder out7;
  private MarbleSolitaireView view7;
  private EnglishSolitaireModel model7;
  private MarbleSolitaireController controller7;
  private StringBuilder outWin;
  private MarbleSolitaireView winView;
  private EnglishSolitaireModel win;
  private StringBuilder outLose;
  private MarbleSolitaireView loseView;
  private EnglishSolitaireModel lose;


  @Before
  public void init() {
    out1 = new StringBuilder();
    out2 = new StringBuilder();
    out3 = new StringBuilder();
    out4 = new StringBuilder();
    out5 = new StringBuilder();
    out6 = new StringBuilder();
    out7 = new StringBuilder();
    outWin = new StringBuilder();
    outLose = new StringBuilder();

    model1 = new MockEnglishSolitaireModel(out1);
    model2 = new MockEnglishSolitaireModel(out2);
    model3 = new MockEnglishSolitaireModel(out3);
    model4 = new MockEnglishSolitaireModel(out4);
    model5 = new MockEnglishSolitaireModel(out5);
    model6 = new EnglishSolitaireModel(3);
    model7 = new EnglishSolitaireModel(5);
    win = new EnglishSolitaireModel();
    lose = new EnglishSolitaireModel();

    view1 = new MarbleSolitaireTextView(model1);
    view2 = new MarbleSolitaireTextView(model2);
    view3 = new MarbleSolitaireTextView(model3);
    view4 = new MarbleSolitaireTextView(model4);
    view5 = new MarbleSolitaireTextView(model5);
    view6 = new MarbleSolitaireTextView(model6, out6);
    view7 = new MarbleSolitaireTextView(model7, out7);
    winView = new MarbleSolitaireTextView(win, outWin);
    loseView = new MarbleSolitaireTextView(lose, outLose);
  }

  @Test
  public void testConstructor() {
    Reader reader1 = new StringReader("");
    controller1 = new MarbleSolitaireControllerImpl(model1, view1, reader1);
    MarbleSolitaireModel nullmodel = null;
    MarbleSolitaireView nullview = null;
    Readable nullreader = null;

    try {
      controller2 = new MarbleSolitaireControllerImpl(nullmodel, view1, reader1);
    } catch (IllegalArgumentException e) {
      assertEquals("null parameters", e.getMessage());
    }

    try {
      controller3 = new MarbleSolitaireControllerImpl(model1, nullview, reader1);
    } catch (IllegalArgumentException e) {
      assertEquals("null parameters", e.getMessage());
    }

    try {
      controller4 = new MarbleSolitaireControllerImpl(model1, view1, nullreader);
    } catch (IllegalArgumentException e) {
      assertEquals("null parameters", e.getMessage());
    }

    try {
      MarbleSolitaireController nullcontroller = new MarbleSolitaireControllerImpl(nullmodel,
              nullview, nullreader);
    } catch (IllegalArgumentException e) {
      assertEquals("null parameters", e.getMessage());
    }
  }

  @Test
  public void testMove() {
    Reader reader1 = new StringReader("4 2 4 4 q");
    controller1 = new MarbleSolitaireControllerImpl(model1, view1, reader1);
    controller1.playGame();
    assertTrue(out1.toString().contains("move: 3 1 3 3"));
    out1 = new StringBuilder();

    Reader reader2 = new StringReader("4 y 2 4 4 q");
    controller2 = new MarbleSolitaireControllerImpl(model2, view2, reader2);
    controller2.playGame();
    assertTrue(out2.toString().contains("move: 3 1 3 3"));
    out2 = new StringBuilder();

    Reader reader3 = new StringReader("1 -1 4 2 4 q");
    controller3 = new MarbleSolitaireControllerImpl(model3, view3, reader3);
    controller3.playGame();
    assertTrue(out3.toString().contains("move: 0 3 1 3"));
    out3 = new StringBuilder();

    Reader reader4 = new StringReader("1\n -1\n 2\n 3\n 4\nq");
    controller4 = new MarbleSolitaireControllerImpl(model4, view4, reader4);
    controller4.playGame();
    assertTrue(out4.toString().contains("move: 0 1 2 3"));
    out4 = new StringBuilder();

    Reader reader5 = new StringReader("1\n -1\n 2\n 3\n 4\n 2 3 4 4 q");
    MarbleSolitaireController controller5 = new MarbleSolitaireControllerImpl(model5,
            view5, reader5);
    controller5.playGame();
    assertTrue(out5.toString().contains("move: 0 1 2 3"));
    assertTrue(out5.toString().contains("move: 1 2 3 3"));
    out5 = new StringBuilder();

    Reader reader6 = new StringReader("4 3 4 1 q");
    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(model6,
            view6, reader6);
    controller6.playGame();
    System.out.println(out6);
  }

  @Test
  public void testQuit() {
    Reader reader6 = new StringReader("q");
    controller6 = new MarbleSolitaireControllerImpl(model6, view6, reader6);
    controller6.playGame();
    assertTrue(out6.toString().contains("Game quit!\nState of game when quit"));
    init();

    Reader reader7 = new StringReader("4 3 4 4 q");
    controller7 = new MarbleSolitaireControllerImpl(model7, view7, reader7);
    controller7.playGame();
    assertTrue(out7.toString().contains("Game quit!\nState of game when quit"));
    init();

    reader6 = new StringReader("4 q 2 4 3");
    controller6 = new MarbleSolitaireControllerImpl(model6, view6, reader6);
    controller6.playGame();
    System.out.print(out6.toString());
    assertTrue(out6.toString().contains("Game quit!\nState of game when quit"));
    init();

    reader6 = new StringReader("4 3 q 4 3");
    controller6 = new MarbleSolitaireControllerImpl(model6, view6, reader6);
    controller6.playGame();
    assertTrue(out6.toString().contains("Game quit!\nState of game when quit"));
    init();

    reader6 = new StringReader("4 3 2 q 3");
    controller6 = new MarbleSolitaireControllerImpl(model6, view6, reader6);
    controller6.playGame();
    assertTrue(out6.toString().contains("Game quit!\nState of game when quit"));
    init();
  }

  @Test
  public void testInvalidInputs() {
    Reader reader6 = new StringReader("4 -1 0 0 q");
    controller6 = new MarbleSolitaireControllerImpl(model6, view6, reader6);
    controller6.playGame();
    assertTrue(out6.toString().contains("Invalid input, Please enter new one"));
    init();

    Reader reader7 = new StringReader("l q");
    controller7 = new MarbleSolitaireControllerImpl(model7, view7, reader7);
    controller7.playGame();
    assertTrue(out7.toString().contains("Invalid input, Please enter new one"));
    init();

    reader7 = new StringReader("l q");
    controller7 = new MarbleSolitaireControllerImpl(model7, view7, reader7);
    controller7.playGame();
    assertTrue(out7.toString().contains("Invalid input, Please enter new one"));
    init();

    reader6 = new StringReader("4 3 3\n p a \n e 2 q");
    controller6 = new MarbleSolitaireControllerImpl(model6, view6, reader6);
    controller6.playGame();
    assertTrue(out6.toString().contains("Invalid input, Please enter new one"));
    init();

    try {
      reader6 = new StringReader("4 3");
      controller6 = new MarbleSolitaireControllerImpl(model6, view6, reader6);
      controller6.playGame();
    } catch (IllegalStateException e) {
      assertEquals("does not end", e.getMessage());
    }

    try {
      reader7 = new StringReader("");
      controller7 = new MarbleSolitaireControllerImpl(model7, view7, reader7);
      controller7.playGame();
    } catch (IllegalStateException e) {
      assertEquals("does not end", e.getMessage());
    }
  }

  @Test
  public void testGameOver() {
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

    lose.move(1, 3, 3, 3);
    lose.move(4, 3, 2, 3);
    lose.move(3, 1, 3, 3);
    lose.move(3, 4, 3, 2);
    lose.move(3, 6, 3, 4);

    Reader reader = new StringReader("2 4 4 4 q");
    controller1 = new MarbleSolitaireControllerImpl(win, winView, reader);
    controller1.playGame();
    assertEquals("    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1\n", outWin.toString());

    Reader reader2 = new StringReader("7 4 5 4");
    controller1 = new MarbleSolitaireControllerImpl(lose, loseView, reader2);
    controller1.playGame();
    assertEquals("    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "Game over!\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O O O O O\n" +
            "O _ O _ O _ _\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O _ O\n" +
            "Score: 26\n", outLose.toString());

  }

  @Test(expected = IllegalStateException.class)
  public void testIOExceptions() {
    MarbleSolitaireView corrupt = new MockMarbleSolitaireTextView(new StringBuilder());
    Reader reader = new StringReader("q");
    controller1 = new MarbleSolitaireControllerImpl(model1, corrupt, reader);
    controller1.playGame();

    Reader reader2 = new StringReader("3 4 2 2 q");
    controller1 = new MarbleSolitaireControllerImpl(model1, corrupt, reader2);
    controller1.playGame();

    Reader reader3 = new StringReader("-2 4 2 q 4");
    controller1 = new MarbleSolitaireControllerImpl(model1, corrupt, reader3);
    controller1.playGame();
  }
}
