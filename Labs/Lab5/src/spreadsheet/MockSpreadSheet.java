package spreadsheet;

/**
 * MockSpreadSheet class that implements SpreadSheet interface.
 */
public class MockSpreadSheet implements SpreadSheet {
  private StringBuilder console;

  public MockSpreadSheet(StringBuilder a) {
    this.console = a;
  }

  @Override
  public double get(int row, int col) throws IllegalArgumentException {
    console.append("get: " + row + " | " + col);
    return 0.0;
  }

  @Override
  public void set(int row, int col, double value) throws IllegalArgumentException {
    console.append("set: " + row + " | " + col + " | " + value);
  }

  @Override
  public boolean isEmpty(int row, int col) throws IllegalArgumentException {
    console.append("isEmpty: " + row + " | " + col);
    return false;
  }

  @Override
  public int getWidth() {
    console.append("getWidth");
    return 0;
  }

  @Override
  public int getHeight() {
    console.append("getHeight");
    return 0;
  }
}
