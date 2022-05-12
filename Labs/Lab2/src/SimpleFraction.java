/**
 * A SimpleFraction class that implements Fraction and is limited to only non-negative
 * simple fractions.
 */
public class SimpleFraction implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructor to create a simple fraction.
   *
   * @param n : the numerator of the simple fraction
   * @param d : the denominator of the simple fraction
   * @throws IllegalArgumentException : throws exception if either numerator or
   *                              denominator are negative but not both or if the denominator is 0
   */
  public SimpleFraction(int n, int d) throws IllegalArgumentException {
    this.numerator = n;
    this.denominator = d;

    if (n < 0 && d < 0) {
      this.numerator = Math.abs(n);
      this.denominator = Math.abs(d);
    } else if (n < 0 || d <= 0) {
      throw new IllegalArgumentException("Invalid numbers (either negative or undefined)");
    }
  }

  /**
   * adds a fraction object to this current fraction object and returns a fraction.
   *
   * @param other : another fraction object
   * @return a fraction object that is the sum of this one and the other one
   */
  @Override
  public Fraction add(Fraction other) {
    return other.add(this.numerator, this.denominator);
  }

  /**
   * adds a fraction in the form of a numerator and denominator to this fraction.
   *
   * @param numerator   : the numerator of a fraction to add to this one
   * @param denominator : the denominator of a fraction to add to this one
   * @return the sum of this fraction added to a numerator and denominator
   */
  @Override
  public Fraction add(int numerator, int denominator) {
    if (numerator < 0 && denominator < 0) {
      return new SimpleFraction(this.numerator * Math.abs(denominator) + Math.abs(numerator)
              * this.denominator,
              this.denominator * Math.abs(denominator));
    } else if (numerator < 0 || denominator <= 0) {
      throw new IllegalArgumentException("no invalid fractions");
    } else {
      return new SimpleFraction(this.numerator * denominator + numerator
              * this.denominator,
              this.denominator * denominator);
    }

  }

  /**
   * returns this fraction as a decimal given a number of places.
   *
   * @param places : the number of places we round to
   * @return a double of the decimal value of the fraction
   */
  @Override
  public double getDecimalValue(int places) {
    String ans = String.format("%." + places + "f", ((double) this.numerator) / this.denominator);
    return Double.parseDouble(ans);
  }

  /**
   * returns this fraction in the form of a string.
   *
   * @return a String of the fraction in n/d form
   */
  @Override
  public String toString() {
    return String.format("%d/%d", this.numerator, this.denominator);
  }
}
