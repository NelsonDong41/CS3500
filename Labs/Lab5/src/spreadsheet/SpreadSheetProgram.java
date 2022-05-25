package spreadsheet;

import java.io.InputStreamReader;

/**
 * main class to run the program.
 */
public class SpreadSheetProgram {
  /**
   * main method to run the program.
   * @param args : the arguments the user inputs
   */
  public static void main(String []args) {
    SpreadSheet model = new SparseSpreadSheet();
    Readable rd = new InputStreamReader(System.in);
    Appendable ap = System.out;
    SpreadSheetController controller = new SpreadSheetController(model,rd,ap);
    controller.go();
  }
}
