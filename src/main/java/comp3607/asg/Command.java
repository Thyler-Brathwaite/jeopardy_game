package comp3607.asg;


import java.util.Scanner;

public interface Command {

 public void SetupCommand(TurnManager t, Scanner s, Board b); 

public boolean execute();

}