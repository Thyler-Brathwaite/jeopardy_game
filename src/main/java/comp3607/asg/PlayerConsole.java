package comp3607.asg;





public class PlayerConsole {

    private final Player player;
    


    public PlayerConsole(Player player) {
        this.player = player;
    }


    public void execute(Command c) {
        if (c == null) {
            return;
        }
        c.execute();
      
    }

  

    public Player getPlayer() {
        return player;
    }
}
