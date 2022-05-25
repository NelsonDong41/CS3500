
/**
 * Abstract class that contains methods for any Question object.
 */
public abstract class AbstractQuestion implements Question {

  protected String questionText;
  protected String enteredAnswer;
  protected String questionType;

  /**
   * Super constructor for the AbstractQuestion class.
   * @param questionText : the question being asked
   * @param enteredAnswer : the answer entered
   * @param questionType : the type of question
   * @throws IllegalArgumentException if there is no question
   */

  public AbstractQuestion(String questionText, String enteredAnswer, String questionType)
          throws IllegalArgumentException {
    if ((questionText.length() == 0)) {
      throw new IllegalArgumentException("Invalid question text");
    }
    this.questionText = questionText;
    this.enteredAnswer = enteredAnswer;
    this.questionType = questionType;
  }

  /**
   * Will return the question.
   * @return : String of the question Text
   */
  @Override
  public String getQuestionText() {
    return questionText;
  }

  /**
   * Will return the type of game.
   * @return : String of the type of game
   */

  @Override
  public String getType() {
    return questionType;
  }

  /**
   * will answer the question with a valid answer.
   * @param enteredAnswer the answer entered for this question by a student
   */
  @Override
  public void answer(String enteredAnswer) {
    this.answerHelper(getStrings(), enteredAnswer);
  }

  protected abstract String[] getStrings();

  protected void answerHelper(String[] list, String enteredAnswer) {
    for (String str : list) {
      if (enteredAnswer.equalsIgnoreCase(str)) {
        this.enteredAnswer = enteredAnswer.toLowerCase();
        return;
      }
    }
    throw new IllegalArgumentException("Invalid Argument: " + enteredAnswer);
  }

  /**
   * returns whether the question has been answered.
   * @return : a boolean of whether the question has been answered
   */
  @Override
  public boolean hasBeenAnswered() {
    String[] list = getStrings();

    for (String str : list) {
      if (str.equals(enteredAnswer.toLowerCase())) {
        return true;
      }
    }
    return false;
  }

  /**
   * returns the answer entered.
   * @return : a string of the answer entered
   * @throws IllegalStateException if the question has not been entered
   */
  @Override
  public String getEnteredAnswer() throws IllegalStateException {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("solution.Question not attempted yet!");
    } else {
      return enteredAnswer;
    }
  }
}

