package comp3607.asg;

public class Player {

    private final String name;
    private final int id;
    private final Score score;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = new Score();
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Score getScore() {
        return this.score;
    }
}
