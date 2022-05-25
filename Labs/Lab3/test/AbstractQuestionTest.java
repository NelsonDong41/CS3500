
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * A class that abstracts the tests from any Question object.
 */

public abstract class AbstractQuestionTest {
  protected String longRandom;

  /**
   * creates an AbstractQuestionTest object.
   * @param longRandom : a given random long string that will be used to create a question
   */
  public AbstractQuestionTest(String longRandom) {
    this.longRandom = longRandom;
  }

  protected abstract Question createQuestion(String text);

  protected abstract String getType();

  protected abstract String[] getCorrectStrings();

  protected abstract String[] getIncorrectStrings();


  /**
   * creates a random question with the longrandom.
   */
  @Test
  public void testCreateValidAbstractQuestion() {
    Random r = new Random(200);
    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start, end);
      Question q = createQuestion(questionText + "?");
      assertEquals(questionText + "?", q.getQuestionText());
      assertEquals(getType(), q.getType());
    }
  }

  /**
   * tests the answer and hasBeenAnswered() method in a correct situation.
   */
  @Test
  public void testAnswerCorrectly() {
    String[] list = getCorrectStrings();
    for (String answer : list) {
      Question q = createQuestion("Is this a trick question?");
      assertFalse(q.hasBeenAnswered());

      q.answer(answer);
      assertEquals(answer.toLowerCase(), q.getEnteredAnswer());
      assertTrue(q.hasBeenAnswered());
    }
  }

  /**
   * tests the answer and hasBeenAnswered() method in an incorrect situation.
   */
  @Test
  public void testAnswerInCorrectly() {
    String[] list = getIncorrectStrings();
    for (String answer : list) {
      Question q = createQuestion("Is this a trick question?");
      assertFalse(q.hasBeenAnswered());

      try {
        q.answer(answer);
        fail("Question accepted an invalid answer");
      }
      catch (IllegalArgumentException e) {
        assertFalse(q.hasBeenAnswered());
      }
    }
  }

  /**
   * tests whether the construction of a question with no text returns an Exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCreateAbstractQuestionNoText() {
    createQuestion("");
  }
}
