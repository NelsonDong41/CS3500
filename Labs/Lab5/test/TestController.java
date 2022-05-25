import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import spreadsheet.BetterMockSpreadSheet;
import spreadsheet.BetterSparseSpreadSheet;
import spreadsheet.BetterSpreadSheet;
import spreadsheet.MockSpreadSheet;
import spreadsheet.SparseSpreadSheet;
import spreadsheet.SpreadSheet;
import spreadsheet.SpreadSheetController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the controller class.
 */
public class TestController {
  StringBuilder out;
  SpreadSheet model;
  BetterSpreadSheet model2;
  MockSpreadSheet mock;
  BetterMockSpreadSheet mock2;
  StringBuilder mockOut;
  StringBuilder mockOut2;
  Reader in;
  SpreadSheetController controller;

  @Before
  public void init() {
    out = new StringBuilder();
    model = new SparseSpreadSheet();
    model2 = new BetterSparseSpreadSheet();
    mock = new MockSpreadSheet(mockOut);
    mock2 = new BetterMockSpreadSheet(mockOut2);
    mockOut = new StringBuilder();
    mockOut2 = new StringBuilder();
  }

  @Test
  public void testGo() throws IOException {

    in = new StringReader("q");
    controller = new SpreadSheetController(model, in, out);
    controller.execute();
    StringBuilder welcomeMessage = new StringBuilder()
            .append("Welcome to the spreadsheet program!" + System.lineSeparator())
            .append("Supported user instructions are: " + System.lineSeparator())
            .append("assign-value row-num col-num value (set a cell to a value)"
                    + System.lineSeparator())
            .append("print-value row-num col-num (print the value at a given cell)"
                    + System.lineSeparator())
            .append("menu (Print supported instruction list)" + System.lineSeparator())
            .append("q or quit (quit the program) " + System.lineSeparator())
            .append("Type instruction: Thank you for using this program!");

    assertEquals(welcomeMessage.toString(), out.toString());
    out.delete(0, out.length());

    in = new StringReader("quit");
    controller = new SpreadSheetController(model, in, out);
    controller.execute();
    assertTrue(out.toString().contains("Thank you for using this program!"));
    out.delete(0, out.length());

    in = new StringReader("assign-value a 1 10 q");
    controller = new SpreadSheetController(mock, in, out);
    controller.execute();
    assertEquals("set: 0 | 0 | 10.0", mockOut.toString());

    //resets the mock console
    mockOut.delete(0, mockOut.length());

    in = new StringReader("print-value a 1 q");
    controller = new SpreadSheetController(mock, in, out);
    controller.execute();
    assertEquals("get: 0 | 0", mockOut.toString());
    mockOut.delete(0, mockOut.length());

    in = new StringReader("bulk-assign a 1 c 3 20 q");
    controller = new SpreadSheetController(mock2, in, out);
    controller.execute();
    assertEquals("bulk-assign: 0 | 1 | 2 | 3 | 20.0", mockOut2.toString());
  }
}