package comp3607.asg;


public class Player {

    private int score;
    private String name;
    private int money;
    private PlayerConsole console;


    public Player(String name) {
        this(name, 0, 0);
    }

    public Player(String name, int startingScore, int startingMoney) {
        this.name = name;
        this.score = startingScore;
        this.money = startingMoney;
        this.console = new PlayerConsole(this); 
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }

    public PlayerConsole getConsole() {
        return console;
    }

    public void addScore(int amount) {
        this.score += amount;
    }

    public void addMoney(int amount) {
        this.money += amount;
    }
}
