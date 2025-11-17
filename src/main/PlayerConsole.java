package comp3607.asg;

import java.util.ArrayList;
import java.util.List;


public class PlayerConsole {

    private Player player;
    private List<Command> history;


    public PlayerConsole(Player player) {
        this.player = player;
        this.history = new ArrayList<>();
    }


    public void execute(Command c) {
        if (c == null) {
            return;
        }
        c.execute();
        history.add(c);
    }

    public void undo(Command c) {
        if (c == null) {
            return;
        }
        if (history.remove(c)) {
            c.undo();
        }
    }


    public void undoLast() {
        if (history.isEmpty()) {
            return;
        }
        Command last = history.remove(history.size() - 1);
        last.undo();
    }

    public Player getPlayer() {
        return player;
    }
}
