package comp3607.asg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TxtReportLoader extends ReportLoader {

    private FileWriter writer;

    public TxtReportLoader() {}

    @Override
    public void openDocument(String filePath) {
        try {
            writer = new FileWriter(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeTitle(String text) {
        try {
            writer.write("=== " + text + " ===\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeFinalScores(Map<String, Integer> scores) {
        try {
            writer.write("Final Scores:\n");
            for (String name : scores.keySet()) {
                writer.write(name + ": " + scores.get(name) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeSpacer() {
        try {
            writer.write("\n----------------------\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeTurnDetails(List<TurnSummary> turns) {
        try {
            writer.write("Turns:\n");
            for (TurnSummary ts : turns) {
                writer.write(ts.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeDocument() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
