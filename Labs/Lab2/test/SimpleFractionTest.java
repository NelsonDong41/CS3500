
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tester class to test the SimpleFraction object methods.
 */
public class SimpleFractionTest {
  private Fraction one;
  private Fraction two;
  private Fraction three;



  @Before
  public void init() {
    one = new SimpleFraction(1, 1);
    two = new SimpleFraction(2, 3);
    three = new SimpleFraction(-3, -2);
  }

  @Test
  public void testConstructor() {
    try {
      Fraction four = new SimpleFraction(-3, 1);
      Fraction five = new SimpleFraction(2, -3);
      Fraction six = new SimpleFraction(4, 0);
      fail("invalid numbers");
    }
    catch (IllegalArgumentException e) {
      System.out.println("it works");
    }
  }

  @Test
  public void testAdd() {
    one = new SimpleFraction(1, 1);
    two = new SimpleFraction(2, 3);
    three = new SimpleFraction(-3, -2);
    assertEquals("5/3", one.add(two).toString());
    assertEquals("5/2", three.add(one).toString());
    assertEquals("1/2", three.add(-1, 1).toString());

    try {
      one.add(-4, 1);
      fail("Did not catch exception");
    }
    catch (IllegalArgumentException e) {
      System.out.println("it works");
    }
  }

  @Test
  public void testToString() {
    assertEquals("1/1", one.toString());
    assertEquals("2/3", two.toString());
    assertEquals("3/2", three.toString());
  }

  @Test
  public void testGetDecimalValue() {
    assertEquals(1.0, one.getDecimalValue(1), 0.1);
    assertEquals(0.667, two.getDecimalValue(3), 0.001);
    assertEquals(1.5, three.getDecimalValue(1), 0.1);
  }

}