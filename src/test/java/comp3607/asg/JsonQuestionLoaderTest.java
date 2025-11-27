package comp3607.asg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonQuestionLoaderTest {

    @Test
    public void testFirstCategoryLoadedCorrectly() {
        // Use the same path you use in Main
        JsonQuestionLoader loader = new JsonQuestionLoader("resources/sample_game_JSON.json");

        // This will ReadFile() + ParseData() + LoadCategory() (first category)
        Category firstCategory = loader.loadQuestions();

        assertNotNull(firstCategory, "First category should not be null.");
        assertEquals("Variables & Data Types", firstCategory.getCategory(),
                "First category name should match JSON data.");

        // JSON has 5 questions in "Variables & Data Types"
        assertEquals(5, firstCategory.getQuestions().size(),
                "Variables & Data Types should have 5 questions.");

        // Check the first question in that category
        Question q0 = firstCategory.getQuestions().get(0);

        assertEquals("Which of the following declares an integer variable in C++?",
                q0.getQuestionText(),
                "Question text should match the JSON file.");

        assertEquals(100, q0.getPrice(),
                "Question value (price) should match the JSON 'Value' field.");

        // In your loader, 'answer' is the option key (A, B, C, D)
        assertEquals("A", q0.getAnswer(),
                "Correct answer key should be 'A' for the first question.");

        // Options map should contain the option text for key "A"
        assertEquals("int num;", q0.getOptions().get("A"),
                "Option A text should be 'int num;'.");
    }

    @Test
    public void testSecondCategoryLoadedOnNextCall() {
        JsonQuestionLoader loader = new JsonQuestionLoader("resources/sample_game_JSON.json");

        // First call: Variables & Data Types
        Category firstCategory = loader.loadQuestions();
        assertNotNull(firstCategory);

        // Because LoadCategory() is protected but in the same package, we can call it here
        Category secondCategory = loader.LoadCategory();

        assertNotNull(secondCategory, "Second category should not be null.");
        assertEquals("Control Structures", secondCategory.getCategory(),
                "Second category name should be 'Control Structures'.");

        // JSON has 5 questions under "Control Structures"
        assertEquals(5, secondCategory.getQuestions().size(),
                "Control Structures should have 5 questions.");

        // Check one of the questions to ensure parsing works
        Question q1 = secondCategory.getQuestions().get(0);

        assertEquals("Which statement is used to make a decision?",
                q1.getQuestionText(),
                "Question text should match for Control Structures 100.");

        assertEquals(100, q1.getPrice(),
                "Question value for first Control Structures question should be 100.");

        assertEquals("A", q1.getAnswer(),
                "Correct answer key for first Control Structures question should be 'A'.");

        assertEquals("if", q1.getOptions().get("A"),
                "Option A for that question should be 'if'.");
    }
}
