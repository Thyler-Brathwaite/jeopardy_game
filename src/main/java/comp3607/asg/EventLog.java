package comp3607.asg;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {

    private int caseId;
    private TurnSummary summary;
    private String log;

    public EventLog() {
        this.caseId = 0;
        this.summary = null;
        this.log = "";
    }

    public void LogEvent(String filePath, TurnSummary summary) {
        this.summary = summary;

     
        this.log = buildLogString(summary);

        createCSV(filePath);
    }

    public void createCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) { 
            writer.write(log + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV: " + e.getMessage());
        }
    }


    public String getTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    private String buildLogString(TurnSummary s) {
        return getTimestamp() + "," +
               s.getTurnNumber() + "," +
               s.getPlayerName() + "," +
               s.getCategory() + "," +
               s.getQuestionValue() + "," +
               s.getQuestionText().replace(",", ";") + "," +  
               s.getAnswerGiven().replace(",", ";") + "," +
               s.isCorrect() + "," +
               s.getPointsEarned() + "," +
               s.getRunningTotal();
    }
}
