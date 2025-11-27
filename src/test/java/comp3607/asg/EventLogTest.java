package comp3607.asg;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventLogTest {

    @Test
    public void testLogEventWritesCsvLineWithAllFields() throws Exception {
        String filePath = "test_eventlog.csv";
        Path path = Paths.get(filePath);

        // Clean up any old file from previous runs
        Files.deleteIfExists(path);

        EventLog log = new EventLog();

        // Build a sample TurnSummary
        TurnSummary s = new TurnSummary();
        s.setTurnNumber(1);
        s.setPlayerName("Alice");
        s.setCategory("Variables & Data Types");
        s.setQuestionValue(100);
        s.setQuestionText("Which of the following declares an integer variable in C++?");
        s.setAnswerGiven("A");
        s.setCorrect(true);
        s.setPointsEarned(100);
        s.setRunningTotal(100);

        // ACT: write one event
        log.LogEvent(filePath, s);

        // ASSERT: file exists and has exactly 1 line
        assertTrue(Files.exists(path), "CSV file should be created by LogEvent().");

        List<String> lines = Files.readAllLines(path);
        assertEquals(1, lines.size(), "CSV file should contain exactly one line after first event.");

        String line = lines.get(0);
        String[] parts = line.split(",");

        // We expect 10 columns: timestamp + 9 fields from TurnSummary
        assertEquals(10, parts.length, "CSV row should have 10 comma-separated values.");

        // We can't easily assert timestamp exactly, but we can assert the rest:
        assertEquals("1", parts[1]);                         // turnNumber
        assertEquals("Alice", parts[2]);                     // playerName
        assertEquals("Variables & Data Types", parts[3]);    // category
        assertEquals("100", parts[4]);                       // questionValue
        assertEquals("Which of the following declares an integer variable in C++?", parts[5]); // questionText
        assertEquals("A", parts[6]);                         // answerGiven
        assertEquals("true", parts[7]);                      // isCorrect
        assertEquals("100", parts[8]);                       // pointsEarned
        assertEquals("100", parts[9]);                       // runningTotal
    }

    @Test
    public void testQuestionAndAnswerCommasAreReplacedWithSemicolons() throws Exception {
        String filePath = "test_eventlog_commas.csv";
        Path path = Paths.get(filePath);

        Files.deleteIfExists(path);

        EventLog log = new EventLog();

        TurnSummary s = new TurnSummary();
        s.setTurnNumber(2);
        s.setPlayerName("Bob");
        s.setCategory("General");
        s.setQuestionValue(200);
        s.setQuestionText("Q,with,comma");
        s.setAnswerGiven("Ans,with,comma");
        s.setCorrect(false);
        s.setPointsEarned(0);
        s.setRunningTotal(0);

        log.LogEvent(filePath, s);

        List<String> lines = Files.readAllLines(path);
        assertEquals(1, lines.size());

        String line = lines.get(0);

        // The commas in questionText and answerGiven should be turned into semicolons
        assertTrue(line.contains("Q;with;comma"), "Question text commas should be replaced by semicolons.");
        assertTrue(line.contains("Ans;with;comma"), "Answer text commas should be replaced by semicolons.");
    }

    @Test
    public void testTimestampFormatLooksReasonable() {
        EventLog log = new EventLog();

        String ts = log.getTimestamp();

        // Basic format check: "yyyy-MM-dd HH:mm:ss"
        assertTrue(ts.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"),
                "Timestamp should match pattern yyyy-MM-dd HH:mm:ss");
    }
}
