/**
 * this class represents a yes/no question.
 */
public class YesNoQuestion extends AbstractQuestion {

  /**
   * Creates a YesNoQuestion object.
   * @param text : the question being asked
   * @throws IllegalArgumentException : if there is no question or
   *        if the question doesn't end with a ?
   */
  public YesNoQuestion(String text) throws IllegalArgumentException {
    super(text, "", "YesNo");
    if (text.charAt(text.length() - 1) != '?') {
      throw new IllegalArgumentException("Invalid question text");
    }
  }

  protected String[] getStrings() {
    return new String[]{"yes", "no"};
  }
}
