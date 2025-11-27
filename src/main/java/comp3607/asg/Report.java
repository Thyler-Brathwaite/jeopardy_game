package comp3607.asg;

import java.util.ArrayList;
import java.util.Map;

public class Report implements Observer {

    private ArrayList<TurnSummary> turnSummaries;
    private Map<String, Integer> finalScores;

    public Report() {
        
        this.turnSummaries = new ArrayList<>();

    }

    @Override
    public void notifyUpdate() {
        System.out.println("Report received update from Leaderboard.");
    }

    public void addTurnSummary(TurnSummary ts) {
        turnSummaries.add(ts);
    }

    public void setFinalScores(Map<String, Integer> scores) {
        this.finalScores = scores;
    }

    public void generateReport(String filePath, ReportLoader loader) {
        loader.reportLoader(filePath, turnSummaries, finalScores);
    }

    public int getLatestPlayerScore(String playerName) {
        if (finalScores == null) return 0;
        return finalScores.getOrDefault(playerName, 0);
    }
}
