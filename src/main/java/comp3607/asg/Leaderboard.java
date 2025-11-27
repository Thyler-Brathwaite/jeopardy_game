package comp3607.asg;

import java.util.ArrayList;

public class Leaderboard implements Subject {

    private ArrayList<Player> rankings = new ArrayList<>();
    private Player rankOne;

    private ArrayList<Observer> observers = new ArrayList<>();

    public Leaderboard() {}

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.notifyUpdate();
        }
    }

    public void updateLeaderboard() {

        if (rankings.isEmpty()) {
            rankOne = null;
            return;
        }

        // Sort by score descending
        rankings.sort((a, b) ->
            Integer.compare(b.getScore().getAmt(), a.getScore().getAmt())
        );

        rankOne = rankings.get(0);

        notifyObservers();
    }

    public void scoreChanged() {
        updateLeaderboard();
    }

    public ArrayList<Player> getRankings() {
        return rankings;
    }

    public Player getRankOne() {
        return rankOne;
    }

    public void addPlayer(Player p) {
        rankings.add(p);
        updateLeaderboard();
    }
}
