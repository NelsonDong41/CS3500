import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests the EnglishSolitaireModel class.
 */
public class TestEnglishSolitaireModel {
  public EnglishSolitaireModel board1;
  public EnglishSolitaireModel board2;
  public EnglishSolitaireModel board3;
  public EnglishSolitaireModel board1MoveTop;

  public MarbleSolitaireTextView view1;
  public MarbleSolitaireTextView view2;
  public MarbleSolitaireTextView view3;
  public MarbleSolitaireTextView view1MoveTop;

  /**
   * initializes the boards.
   */
  @Before
  public void initConditions() {
    board1 = new EnglishSolitaireModel();
    board2 = new EnglishSolitaireModel(3);
    board3 = new EnglishSolitaireModel(5, 4, 4);

    board1MoveTop = new EnglishSolitaireModel(3, 3, 1);

    view1 = new MarbleSolitaireTextView(board1);
    view2 = new MarbleSolitaireTextView(board2);
    view3 = new MarbleSolitaireTextView(board3);

    view1MoveTop = new MarbleSolitaireTextView(board1MoveTop);

  }

  @Test
  public void testInitBoard() {

    try {
      EnglishSolitaireModel board4 = new EnglishSolitaireModel(2);
      EnglishSolitaireModel board5 = new EnglishSolitaireModel(3, 1, 1);
      EnglishSolitaireModel board6 = new EnglishSolitaireModel(3, 8, 3);
      EnglishSolitaireModel board7 = new EnglishSolitaireModel(3, 3, 10);
      throw new IllegalArgumentException();
    } catch (IllegalArgumentException ignored) {
    }
  }

  @Test
  public void testToString() {
    assertEquals("  ooo  \n  ooo  \nooooooo\nooo-ooo\nooooooo\n  ooo  \n  ooo  ",
            view1.toString());
    assertEquals("  ooo  \n  ooo  \nooooooo\nooo-ooo\nooooooo\n  ooo  \n  ooo  ",
            view2.toString());
    assertEquals("    ooooo    \n" +
                    "    ooooo    \n" +
                    "    ooooo    \n" +
                    "    ooooo    \n" +
                    "oooo-oooooooo\n" +
                    "ooooooooooooo\n" +
                    "ooooooooooooo\n" +
                    "ooooooooooooo\n" +
                    "ooooooooooooo\n" +
                    "    ooooo    \n" +
                    "    ooooo    \n" +
                    "    ooooo    \n" +
                    "    ooooo    ",
            view3.toString());

  }

  @Test
  public void move() {
    this.board1.move(3, 1, 3,3);
    assertEquals("  ooo  \n  ooo  \nooooooo\no--oooo\nooooooo\n  ooo  \n  ooo  ", view1.toString());
    try {
      board1.move(0,0,0,1);
      board2.move(3, 3, 3,1);
      board1.move(3, 2,3,3);

    } catch (IllegalArgumentException ignored){}

  }

  @Test
  public void isGameOver() {
  }

  @Test
  public void getBoardSize() {
  }

  @Test
  public void getSlotAt() {
  }

  @Test
  public void getScore() {
  }
}
