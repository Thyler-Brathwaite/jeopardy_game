package comp3607.asg;

public class Score {

    private int amt;

    public Score() {
        this.amt = 0;
    }

    public int getScore() {
        return this.amt;
    }

    public void AddScore(int s) {
        this.amt += s;
    }

    public void LoseScore(int s) {
        
        this.amt -= s;
        if (this.amt < 0) this.amt = 0; 
    }
}
