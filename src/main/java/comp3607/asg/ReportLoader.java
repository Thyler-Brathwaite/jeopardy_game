package comp3607.asg;

import java.util.List;
import java.util.Map;

public abstract class ReportLoader {

    public ReportLoader() {}

 
    public final void reportLoader(String filePath, List<TurnSummary> turns, Map<String, Integer> scores) {

        openDocument(filePath);
        writeTitle("Game Report");
        writeSpacer();
        writeTurnDetails(turns);
        writeSpacer();
        writeFinalScores(scores);
        closeDocument();
    }

    public abstract void openDocument(String filePath);
    public abstract void writeTitle(String text);
    public abstract void writeFinalScores(Map<String, Integer> scores);
    public abstract void writeSpacer();
    public abstract void writeTurnDetails(List<TurnSummary> turns);
    public abstract void closeDocument();
}
