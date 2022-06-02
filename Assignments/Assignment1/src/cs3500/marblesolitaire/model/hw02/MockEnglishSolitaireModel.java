package cs3500.marblesolitaire.model.hw02;

/**
 * class for mockEnglishSolitaireModel.
 */
public class MockEnglishSolitaireModel implements MarbleSolitaireModel {

  private StringBuilder console;


  /**
   * constructor that inputs an Appendable as a console.
   * @param a : Stringbuilder
   */
  public MockEnglishSolitaireModel(StringBuilder a) {
    this.console = a;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    console.append("move: ")
            .append(fromRow)
            .append(" ")
            .append(fromCol)
            .append(" ")
            .append(toRow)
            .append(" ")
            .append(toCol);
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public int getBoardSize() {
    console.append("getBoardSize");
    return 0;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    console.append("getSlotAt: ")
            .append(row)
            .append(" ")
            .append(col);
    return null;
  }

  @Override
  public int getScore() {
    console.append("getScore");
    return 0;
  }
}
