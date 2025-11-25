package comp3607.asg;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class DocxReportLoader extends ReportLoader {

    private PrintWriter writer;

    public DocxReportLoader() {}

    @Override
    public void openDocument(String filePath) {
        try {
            writer = new PrintWriter(new FileWriter(filePath));
            writer.println("===== DOCX REPORT START =====");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeTitle(String text) {
        writer.println("<<DOCX TITLE>> " + text);
    }

    @Override
    public void writeSpacer() {
        writer.println("=========================================");
    }

    @Override
    public void writeFinalScores(Map<String, Integer> scores) {
        writer.println("<<DOCX FINAL SCORES>>");
        for (String name : scores.keySet()) {
            writer.println("- " + name + ": " + scores.get(name));
        }
    }

    @Override
    public void writeTurnDetails(List<TurnSummary> turns) {
        writer.println("<<DOCX TURN DETAILS>>");
        for (TurnSummary ts : turns) {
            writer.println("- " + ts.toString());
        }
    }

    @Override
    public void closeDocument() {
        writer.println("===== DOCX REPORT END =====");
        writer.close();
    }
}
