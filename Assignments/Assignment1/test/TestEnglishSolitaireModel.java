import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests the EnglishSolitaireModel class.
 */
public class TestEnglishSolitaireModel {
  public EnglishSolitaireModel board1;
  public EnglishSolitaireModel board2;
  public EnglishSolitaireModel board3;
  public EnglishSolitaireModel board4;

  public EnglishSolitaireModel board5;

  public EnglishSolitaireModel win;
  public EnglishSolitaireModel lose;
  public MarbleSolitaireTextView view1;
  public MarbleSolitaireTextView view2;
  public MarbleSolitaireTextView view3;
  public MarbleSolitaireTextView view4;
  public MarbleSolitaireTextView view5;

  public MarbleSolitaireTextView winView;
  public MarbleSolitaireTextView loseView;

  @Before
  public void testInitBoard() {
    board1 = new EnglishSolitaireModel();
    board2 = new EnglishSolitaireModel(3);
    board3 = new EnglishSolitaireModel(3, 2);
    board4 = new EnglishSolitaireModel(5, 4, 4);
    board5 = new EnglishSolitaireModel();
    win = new EnglishSolitaireModel();
    lose = new EnglishSolitaireModel();

    view1 = new MarbleSolitaireTextView(board1);
    view2 = new MarbleSolitaireTextView(board2);
    view3 = new MarbleSolitaireTextView(board3);
    view4 = new MarbleSolitaireTextView(board4);
    view5 =  new MarbleSolitaireTextView(board5);
    winView = new MarbleSolitaireTextView(win);
    loseView = new MarbleSolitaireTextView(lose);

    try {
      EnglishSolitaireModel board6 = new EnglishSolitaireModel(2);
      EnglishSolitaireModel board7 = new EnglishSolitaireModel(3, 1, 1);
      EnglishSolitaireModel board8 = new EnglishSolitaireModel(3, 8, 3);
      EnglishSolitaireModel board9 = new EnglishSolitaireModel(3, 3, 10);
      fail("Constructor did not throw an error");
    } catch (IllegalArgumentException ignored) {
    }

    board5.move(3,1, 3,3);
    board5.move(3,4,3,2);

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
                    "\nO O O _ O O O" +
                    "\nO O O O O O O" +
                    "\n    O O O" +
                    "\n    O O O",
            view2.toString());
    assertEquals("    O O O" +
                    "\n    O O O" +
                    "\nO O O O O O O" +
                    "\nO O _ O O O O" +
                    "\nO O O O O O O" +
                    "\n    O O O" +
                    "\n    O O O",
            view3.toString());
    assertEquals("        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "O O O O _ O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O",
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
  public void move() {
    this.board1.move(3, 1, 3, 3);
    assertEquals("    O O O" +
                    "\n    O O O" +
                    "\nO O O O O O O" +
                    "\nO _ _ O O O O" +
                    "\nO O O O O O O" +
                    "\n    O O O" +
                    "\n    O O O",
            view1.toString());

    this.board2.move(1, 3, 3, 3);
    assertEquals("    O O O" +
                    "\n    O _ O" +
                    "\nO O O _ O O O" +
                    "\nO O O O O O O" +
                    "\nO O O O O O O" +
                    "\n    O O O" +
                    "\n    O O O",
            view2.toString());

    this.board3.move(5, 2, 3, 2);
    assertEquals("    O O O" +
                    "\n    O O O" +
                    "\nO O O O O O O" +
                    "\nO O O O O O O" +
                    "\nO O _ O O O O" +
                    "\n    _ O O" +
                    "\n    O O O",
            view3.toString());

    this.board4.move(4, 2, 4, 4);
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O _ _ O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            view4.toString());

    this.board4.move(4, 0, 4, 2);
    assertEquals("        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "_ _ O _ O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O",
            view4.toString());
    try {
      board1.move(0, 0, 0, 1);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board2.move(3, 3, 3, 1);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board1.move(3, 2, 3, 3);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board3.move(3, 0, 0, 0);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board4.move(0, 0, 5, 4);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board4.move(0, 0, 5, 4);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board1.move(-1, -1, 3, 2);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board1.move(3, 2, -1, -1);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board4.move(5, 2, 3, 2);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board3.move(3, 3, 3, 3);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board3.move(3, 1, 3, 1);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      win.move(3, 3, 3, 2);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      win.move(3, 3, 3, 2);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      win.move(3, 1, 3, 3);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      lose.move(2, 1, 2, 2);
      fail("Did not throw error for illegal moves");
    } catch (IllegalArgumentException ignored) { }

    try {
      board5.move(3,1,3,3);
      fail();
    } catch (IllegalArgumentException ignored) { }
  }

  @Test
  public void testIsGameOver() {
    assertFalse(board1.isGameOver());
    assertFalse(board2.isGameOver());
    assertFalse(board3.isGameOver());
    assertFalse(board4.isGameOver());

    assertTrue(win.isGameOver());
    assertTrue(lose.isGameOver());
  }

  @Test
  public void testGetBoardSize() {
    assertEquals(7, board1.getBoardSize());
    assertEquals(7, board2.getBoardSize());
    assertEquals(7, board3.getBoardSize());
    assertEquals(13, board4.getBoardSize());
    assertEquals(7, win.getBoardSize());
    assertEquals(7, lose.getBoardSize());
  }

  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, board1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, board1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, board1.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, win.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, win.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, win.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, lose.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, lose.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, lose.getSlotAt(1, 1));

    try {
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, board1.getSlotAt(-1, -1));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, board1.getSlotAt(10, 10));
      assertEquals(MarbleSolitaireModelState.SlotState.Empty, win.getSlotAt(-10, 10));
      assertEquals(MarbleSolitaireModelState.SlotState.Invalid, lose.getSlotAt(10, -10));
      fail("Did not throw error for invalid bounds");
    } catch (IllegalArgumentException ignored) {
    }
  }

  @Test
  public void testGetScore() {
    assertEquals(32, board1.getScore());
    assertEquals(32, board2.getScore());
    assertEquals(32, board3.getScore());
    assertEquals(104, board4.getScore());


    board1.move(3, 1, 3, 3);
    assertEquals(31, board1.getScore());
    assertEquals(1, win.getScore());
    assertEquals(26, lose.getScore());
  }
}
