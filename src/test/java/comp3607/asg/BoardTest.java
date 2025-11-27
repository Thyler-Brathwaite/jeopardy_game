package comp3607.asg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testAddCategory() {
        Board board = new Board();
        Category c = new Category("Math");

        board.addCategory(c);

        assertEquals(1, board.getCategories().size(),
                "Board should store exactly 1 category after adding.");
    }

    @Test
    public void testGetCategoryByName() {
        Board board = new Board();

        Category c1 = new Category("Math");
        Category c2 = new Category("Science");

        board.addCategory(c1);
        board.addCategory(c2);

        Categoryable found = board.getCategoryByName("Science");

        assertNotNull(found, "Category should be found by name.");
        assertEquals("Science", found.getCategory());
    }

    @Test
    public void testAllQuestionsAnsweredFalse() {
        Board board = new Board();
        Category c = new Category("General");

        Question q = new Question("Test?", "Yes");
        q.setPrice(100);
        c.addQuestion(q);

        board.addCategory(c);

        assertFalse(board.allQuestionsAnswered(),
                "Should be false because question not used.");
    }

    @Test
    public void testAllQuestionsAnsweredTrue() {
        Board board = new Board();
        Category c = new Category("General");

        Question q = new Question("Test?", "Yes");
        q.setPrice(100);
        q.markUsed(); 

        c.addQuestion(q);
        board.addCategory(c);

        assertTrue(board.allQuestionsAnswered(),
                "Should be true when all questions are used.");
    }
}
