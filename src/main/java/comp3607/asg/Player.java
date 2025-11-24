package comp3607.asg;

public class Player {

    private final String name;
    private final int Id;
    private final Score Score;
   

    public Player(String name, int Id) {
        this.name = name;
        this.Id = Id;
        this.Score = new Score();
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

}
