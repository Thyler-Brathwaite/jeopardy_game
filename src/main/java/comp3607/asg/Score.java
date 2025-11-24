package comp3607.asg;

public class Score {

    private int Score;

    public Score() {
        this.Score = 0;
    }

    public int getScore() {
        return this.Score;
    }

    public void AddScore(int s) {
        this.Score += s;
    }

    public void LoseScore(int s) {
        
        this.Score -= s;
        if (this.Score < 0) this.Score = 0; 
    }
}
