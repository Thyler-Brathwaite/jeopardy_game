package comp3607.asg;

import java.util.Scanner;

public class AnswerCommand implements Command {

    private TurnManager turnManager;
    private Scanner scanner;
    private Board board;

    @Override
    public void SetupCommand(TurnManager t, Scanner s, Board b) {
        this.turnManager = t;
        this.scanner = s;
        this.board = b;
    }

    @Override
    public boolean execute() {
        System.out.println("Please provide your answer: ");
        String answer = scanner.nextLine();

        Questionable chosenQuestion = turnManager.getChosenQuestion();

        turnManager.setChosenAnswer(answer);

        boolean correct = chosenQuestion.checkCorrect(answer);

        if (correct) {
            turnManager.getCurrentPlayer().getScore().addScore(chosenQuestion.getPrice());
        } else {
            turnManager.getCurrentPlayer().getScore().loseScore(chosenQuestion.getPrice());
        }

        chosenQuestion.markUsed();

        return correct;
    }
}
