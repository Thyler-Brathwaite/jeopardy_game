package comp3607.asg;

public class Player {

    private int score;
    private String name;
    private int Id;
    private Score Score;
    private PlayerConsole console;

    public Player(String name, int Id) {
        this.name = name;
        this.Id = Id;
        this.Score = new Score();
        this.console = new PlayerConsole(this);
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.Id;
    }

    public Score getScore() {
        return this.Score;
    }

    public PlayerConsole getConsole() {
        return this.console;
    }
}
