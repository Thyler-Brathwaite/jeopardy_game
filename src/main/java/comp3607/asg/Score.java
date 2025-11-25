package comp3607.asg;

public class Score {

    private int amt;
    @SuppressWarnings("unused")
    private int lastAdded;

    public Score() {
        this.amt = 0;
        this.lastAdded = 0;
    }

    public int getAmt() {
        return this.amt;
    }

    public int getLastAdded() {
        return this.lastAdded;
    }

    public void setLastAdded(int l){
        this.lastAdded = l;
    }

    public void addScore(int s){
        setLastAdded(s);
        this.amt += s;
    }

    public void loseScore(int s) {
        
        this.amt -= s;
        if (this.amt < 0) this.amt = 0; 
    }
}
