package comp3607.asg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    @Test
    public void testIsUsedFlagAndMarkUsed() {
        Question q = new Question("What is 2+2?", "4");
        assertFalse(q.isUsed(), "New question should not be marked used.");

        q.markUsed();
        assertTrue(q.isUsed(), "Question should be marked used after markUsed().");
    }

    @Test
    public void testSetAndGetPrice() {
        Question q = new Question("What is 2+2?", "4");
        q.setPrice(200);
        assertEquals(200, q.getPrice(), "Price should be stored correctly.");
    }

    @Test
    public void testCheckCorrectAnswerCorrect() {
        Question q = new Question("Capital of France?", "Paris");

        String result = q.checkCorrect("Paris");

        assertTrue(result.startsWith("Correct"),
                "checkCorrect should return a message starting with 'Correct' for correct answers.");
    }

    @Test
    public void testCheckCorrectAnswerIncorrect() {
        Question q = new Question("Capital of France?", "Paris");

        String result = q.checkCorrect("London");

        assertTrue(result.startsWith("Incorrect"),
                "checkCorrect should indicate incorrect when answer is wrong.");
        assertTrue(result.contains("Paris"),
                "Incorrect message should show the correct answer.");
    }
}