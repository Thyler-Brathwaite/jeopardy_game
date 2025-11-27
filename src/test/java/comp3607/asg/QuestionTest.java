package comp3607.asg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    public void testIsUsedFlagAndMarkUsed() {
        Question q = new Question("What is 2+2?", "4");

        // New question should not be used
        assertFalse(q.isUsed(), "New question should not be marked used.");

        // After markUsed() it should be used
        q.markUsed();
        assertTrue(q.isUsed(), "Question should be marked used after markUsed().");
    }

    @Test
    public void testSetAndGetPrice() {
        Question q = new Question("What is 2+2?", "4");

        q.setPrice(200);

        assertEquals(200, q.getPrice(),
                "Price should be stored and returned correctly.");
    }

    @Test
    public void testCheckCorrectAnswerReturnsTrueForCorrect() {
        Question q = new Question("Capital of France?", "Paris");

        boolean result = q.checkCorrect("Paris");

        assertTrue(result,
                "checkCorrect should return true for the correct answer.");
    }

    @Test
    public void testCheckCorrectAnswerReturnsFalseForIncorrect() {
        Question q = new Question("Capital of France?", "Paris");

        boolean result = q.checkCorrect("London");

        assertFalse(result,
                "checkCorrect should return false for an incorrect answer.");
    }
}


