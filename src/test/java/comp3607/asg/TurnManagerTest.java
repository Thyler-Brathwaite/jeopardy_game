package comp3607.asg;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class TurnManagerTest {

    @Test
    public void testPlayTurnEndToEndCorrectAnswer() {

        // --- Arrange: build the board from the real JSON file ---
        JsonQuestionLoader loader = new JsonQuestionLoader("resources/sample_game_JSON.json");
        Board board = new Board();

        Category c = loader.loadQuestions();
        while (c != null) {
            board.addCategory(c);
            c = loader.LoadCategory();   // load next category from the map
        }

        Player player = new Player("Alice", 1);
        TurnManager tm = new TurnManager();

        // --- Arrange: fake the user input sequence ---
        // 1) Category name
        // 2) Question value
        // 3) Answer (option key)
        String fakeInput = String.join(System.lineSeparator(),
                "Variables & Data Types",   // category user types
                "100",                      // question value
                "A"                         // correct answer
        ) + System.lineSeparator();

        // Save the real System.in so we can restore it later
        InputStream originalIn = System.in;

        try {
            // Make System.in read from our fake input instead of the keyboard
            System.setIn(new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8)));

            // --- Act: play a full turn using the fake input ---
            TurnSummary summary = tm.PlayTurn(player, board);

            // --- Assert: TurnSummary is correct ---
            assertEquals("Alice", summary.getPlayerName());
            assertEquals("Variables & Data Types", summary.getCategory());
            assertEquals(100, summary.getQuestionValue());

            assertEquals("Which of the following declares an integer variable in C++?",
                    summary.getQuestionText());

            assertEquals("A", summary.getAnswerGiven());
            assertTrue(summary.isCorrect(), "Answer should be marked correct.");

            // Points earned and running total should equal question value
            assertEquals(100, summary.getPointsEarned());
            assertEquals(100, summary.getRunningTotal());

            // First turn should be #1
            assertEquals(1, summary.getTurnNumber());

            // Player score object should match
            assertEquals(100, player.getScore().getAmt());

        } finally {
            // Always restore System.in so we don’t break other tests / code
            System.setIn(originalIn);
        }
    }
}
 