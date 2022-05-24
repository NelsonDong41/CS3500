
/**
 * A test class for the MultipleChoice question object.
 */
public class MultipleChoiceQuestionTest extends AbstractQuestionTest {
  protected String longRandom;

  /**
   * constructor that initializes the longRandom variable
   * in the super class to be this given longRandom.
   */
  public MultipleChoiceQuestionTest() {
    super("aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn");
  }

  @Override
  protected Question createQuestion(String text) {
    return new MultipleChoiceQuestion(text);
  }

  @Override
  protected String getType() {
    return "MultipleChoice";
  }

  @Override
  protected String[] getCorrectStrings() {
    return new String[]{"1", "2", "3", "4"};
  }

  @Override
  protected String[] getIncorrectStrings() {
    return new String[]{"5", ""};
  }
}