import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

public class TestEnglishSolitaireModel {
  public EnglishSolitaireModel board1;
  public EnglishSolitaireModel board2;
  public EnglishSolitaireModel board3;

  public MarbleSolitaireTextView view1;
  public MarbleSolitaireTextView view2;
  public MarbleSolitaireTextView view3;

  @Before
  public void testInitBoard() {
    board1 = new EnglishSolitaireModel();
    board2 = new EnglishSolitaireModel(3);
    board3 = new EnglishSolitaireModel(5, 4, 4);

    view1 = new MarbleSolitaireTextView(board1);
    view2 = new MarbleSolitaireTextView(board2);
    view3 = new MarbleSolitaireTextView(board3);

  }

  @Test
  public void testToString() {
    System.out.println(this.view1.toString());
    assertEquals("  ooo  \n  ooo  \nooooooo\nooo-ooo\nooooooo\n  ooo  \n  ooo  ", view1.toString());
  }

  @Test
  public void move() {
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
