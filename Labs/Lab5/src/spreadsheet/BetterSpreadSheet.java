package spreadsheet;

/**
 * interface for BetterSpreadSheet.
 */
public interface BetterSpreadSheet extends SpreadSheet {
  public void bulkAssign(int sRow, int sCol, int eRow, int eCol, double value);

}
