package comp3607.asg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private final List<Player> players;
    private final Board board;
    private final TurnManager turnManager;
    private final EventLog eventLog;
    private final Report report;
    private boolean running;
    private Leaderboard leaderboard;

    public Game(Board board) {
        this.players = new ArrayList<>();
        this.board = board;
        this.turnManager = new TurnManager();
        this.eventLog = new EventLog();
        this.running = false;
        this.leaderboard = new Leaderboard();
        this.report = new Report();
    }

    public void addPlayer(Player p) {
        players.add(p);
        leaderboard.addPlayer(p);

    
        leaderboard.registerObserver(report);

        System.out.println("Player added: " + p.getName());
    }

    public void start() {

        if (players.isEmpty()) {
            System.out.println("No players added. Cannot start game.");
            return;
        }

        running = true;
        System.out.println("\n=== GAME START ===\n");

        int currentIndex = 0;

        while (running && !board.allQuestionsAnswered()) {

            Player currentPlayer = players.get(currentIndex);

            System.out.println("\n--------------------------------");
            System.out.println("TURN FOR: " + currentPlayer.getName());
            System.out.println("--------------------------------");

            TurnSummary summary = turnManager.PlayTurn(currentPlayer, board);

           
            report.addTurnSummary(summary);

          
            eventLog.LogEvent("eventlog.csv", summary);

            
            leaderboard.scoreChanged();
            displayLeaderboard();

           
            currentIndex = (currentIndex + 1) % players.size();
        }

        end();
    }

    public void end() {
        running = false;

        System.out.println("\n=== GAME OVER ===\n");

        System.out.println("Final Scores:");
        players.sort((a, b) -> b.getScore().getAmt() - a.getScore().getAmt());
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getScore().getAmt());
        }

       
        report.setFinalScores(buildFinalScores());

        ReportLoader loader = new PdfReportLoader();
        report.generateReport("game_report.pdf", loader);

        System.out.println("\nEvent log saved to eventlog.csv");
        System.out.println("PDF Report saved to game_report.pdf");
        System.out.println("Thank you for playing!");
    }

    private Map<String, Integer> buildFinalScores() {
        Map<String, Integer> m = new HashMap<>();
        for (Player p : players) {
            m.put(p.getName(), p.getScore().getAmt());
        }
        return m;
    }

    public void displayLeaderboard() {

        System.out.println("\n===== CURRENT LEADERBOARD =====");

        ArrayList<Player> ranks = leaderboard.getRankings();

        int position = 1;
        for (Player p : ranks) {
            System.out.println(position + ". " + p.getName() + " - " + p.getScore().getAmt());
            position++;
        }

        System.out.println("================================\n");
    }
}
