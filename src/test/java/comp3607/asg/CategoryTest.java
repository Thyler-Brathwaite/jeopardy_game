package comp3607.asg;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void testAddQuestion() {
        Category c = new Category("Math");
        Question q = new Question("2+2?", "4");
        q.setPrice(100);

        c.addQuestion(q);

        assertEquals(1, c.getQuestions().size(),
                "Category should contain exactly 1 question after adding.");
        assertSame(q, c.getQuestions().get(0),
                "Stored question should match the added question.");
    }

    @Test
    public void testFindQuestion() {
        Category c = new Category("Science");

        Question q100 = new Question("Boiling point?", "100C");
        q100.setPrice(100);
        Question q200 = new Question("Freezing?", "0C");
        q200.setPrice(200);

        c.addQuestion(q100);
        c.addQuestion(q200);

        Question found = c.findQuestion(200);

        assertNotNull(found, "Should find question with price 200.");
        assertEquals("Freezing?", found.getQuestionText());
    }

    @Test
    public void testFindQuestionNotFound() {
        Category c = new Category("History");

        Question q = new Question("Year?", "1990");
        q.setPrice(100);
        c.addQuestion(q);

        Question found = c.findQuestion(500);

        assertNull(found, "Should return null when no question matches.");
    }

    @Test
    public void testRemoveQuestion() {
        Category c = new Category("General");
        Question q = new Question("Test?", "Ans");
        q.setPrice(50);

        c.addQuestion(q);
        c.removeQuestion(q);

        assertTrue(c.getQuestions().isEmpty(),
                "Category should be empty after removing the question.");
    }
}
