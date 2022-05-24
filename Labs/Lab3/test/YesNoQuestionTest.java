
import org.junit.Test;

/**
 * A test class for the YesNo question object.
 */
public class YesNoQuestionTest extends AbstractQuestionTest {

  /**
   * initializes the longRandom variable in the super class to be this given longRandom.
   */
  public YesNoQuestionTest() {
    super("aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn");
  }

  @Override
  protected Question createQuestion(String text) {
    return new YesNoQuestion(text);
  }

  @Override
  protected String getType() {
    return "YesNo";
  }

  @Override
  protected String[] getCorrectStrings() {
    return new String[]{"yes", "Yes", "YEs", "YeS", "YES", "yEs", "yES", "yeS",
        "no", "No", "nO", "NO"};
  }

  @Override
  protected String[] getIncorrectStrings() {
    return new String[]{"yess", ""};
  }

  /**
   * tests whether the construction of a YesNo question with no question mark returns an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateYesNoQuestionNoQuestionMark() {
    new YesNoQuestion("Is this fun");
  }
}