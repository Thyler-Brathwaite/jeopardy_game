package comp3607.asg;

import java.util.Scanner;

public class PlayerConsole {

    private final Scanner scanner = new Scanner(System.in);
    private TurnManager turnManager;
    private Board board;

    public PlayerConsole(TurnManager t, Board b) {
        this.turnManager = t;
        this.board = b;
    }

    public boolean execute(Command c) {
        if (c == null) return false;

        c.SetupCommand(turnManager, scanner, board);
        return c.execute();
    }
}
