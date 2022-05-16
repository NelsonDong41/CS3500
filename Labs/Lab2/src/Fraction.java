/**
 * An interface for fraction objects.
 */
public interface Fraction {
  /**
   * adds a fraction object to this current fraction object and returns a fraction.
   *    @param other : another fraction to add to this one
   *    @return a fraction that is the sum of this one and the other one
   */
  Fraction add(Fraction other);

  /**
   * adds a fraction in the form of a numerator and denominator to this fraction.
   *    @param numerator : the numerator of a fraction to add to this one
   *    @param denominator : the denominator of a fraction to add to this one
   *    @return the sum of this fraction added to a numerator and denominator
   */
  Fraction add(int numerator, int denominator);

  /**
   * returns this fraction as a decimal given a number of places.
   *    @param places : the number of places we round to
   *    @return a double of the decimal value of the fraction
   */
  double getDecimalValue(int places);
}
