/**
 * A class for MultipleChoice questions.
 */
public class MultipleChoiceQuestion extends AbstractQuestion {
  /**
   * Super constructor for the AbstractQuestion class.
   *
   * @param text : the question being asked
   * @throws IllegalArgumentException if there is no question
   */
  public MultipleChoiceQuestion(String text) throws IllegalArgumentException {
    super(text, "", "MultipleChoice");
  }

  @Override
  protected String[] getStrings() {
    return new String[] { "1", "2", "3", "4" };
  }
}
