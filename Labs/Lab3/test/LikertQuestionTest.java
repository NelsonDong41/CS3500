
/**
 * A test class for the YesNo question object.
 */
public class LikertQuestionTest extends AbstractQuestionTest {

  /**
   * constructor that initializes the longRandom variable
   * in the super class to be this given longRandom.
   */
  public LikertQuestionTest() {
    super("aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn");
  }

  @Override
  protected Question createQuestion(String text) {
    return new LikertQuestion(text);
  }

  @Override
  protected String getType() {
    return "Likert";
  }

  @Override
  protected String[] getCorrectStrings() {
    return new String[]{"strongly agree",
        "agree",
        "neither agree nor disagree",
        "disagree",
        "strongly disagree"};
  }

  @Override
  protected String[] getIncorrectStrings() {
    return new String[]{"weakly disagree", ""};
  }

}