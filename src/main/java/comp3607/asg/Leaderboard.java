package comp3607.asg;

import java.util.ArrayList;

public class Leaderboard implements Subject {

    private ArrayList<Player> rankings = new ArrayList<>();
    private Player rankOne;

    private ArrayList<Observer> observers = new ArrayList<>();

    public Leaderboard() {}

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
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

    public void update() {
        // Some logic to update rankings (sorting etc.)
        //RankPlayers();

        // After rankings change → notify all observers
        notifyObservers();
    }

   /*  public ArrayList<Player> RankPlayers() {
        // Simple example: sort by score descending
        rankings.sort((a, b) -> b.getScore() - a.getScore());
        if (!rankings.isEmpty()) {
            rankOne = rankings.get(0);
        }
        return rankings;
    }
  */
    public Player getRankOne() {
        return rankOne;
    }

    // Optional helper to add players
    public void addPlayer(Player p) {
        rankings.add(p);
    }
}
