
/**
 * this class represents a 5-scale likert question
 * the scales are strongly agree, agree, neither agree nor disagree, disagree and strongly disagree.
 */
public class LikertQuestion extends AbstractQuestion {

  /**
   * creates a LikertQuestion object.
   *
   * @param text : the question being asked
   * @throws IllegalArgumentException if there is no question
   */
  public LikertQuestion(String text) throws IllegalArgumentException {
    super(text, "", "Likert");
  }

  protected String[] getStrings() {
    return new String[]{"strongly agree",
        "agree",
        "neither agree nor disagree",
        "disagree",
        "strongly disagree"};
  }
}
