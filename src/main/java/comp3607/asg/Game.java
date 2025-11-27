package comp3607.asg;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Player> players;
    private final Board board;
    private final TurnManager turnManager;
    private final EventLog eventLog;
    private boolean running;

    public Game(Board board) {
        this.players = new ArrayList<>();
        this.board = board;
        this.turnManager = new TurnManager();
        this.eventLog = new EventLog();
        this.running = false;
    }

    public void addPlayer(Player p) {
        players.add(p);
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

            // Log CSV line
            eventLog.LogEvent("eventlog.csv", summary);

            // Move to next player
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

        System.out.println("\nEvent log saved to eventlog.csv");
        System.out.println("Thank you for playing!");
    }
}
