package comp3607.asg;

import java.util.Scanner;

public class SelectQuestionCommand implements Command {

    private TurnManager turnManager;
    private Scanner scanner;
    private Board board;
    private String answer;

    @Override
    public void SetupCommand(TurnManager t, Scanner s, Board b) {
        this.turnManager = t;
        this.scanner = s;
        this.board = b;
    }

    @Override
    public boolean execute() {

        System.out.println("\n Please select a price from the chosen category : \n");
        answer = scanner.nextLine();

        int price;

        try {
            price = Integer.parseInt(answer.trim());
        } catch (NumberFormatException e) {
            System.out.println("\n Invalid input. Please type a number only.\n");
            return false;
        }

        Categoryable cat = turnManager.getChosenCategory();
        if (cat == null) {
            System.out.println("\n ERROR: No category selected.\n");
            return false;
        }

        Questionable selectedQuestion = cat.findQuestion(price);

        if (selectedQuestion == null) {
            System.out.println("\n No question found with that price.\n");
            return false;
        }

        if (selectedQuestion.isUsed()) {
            System.out.println("\n This question was already used. Choose another.\n");
            return false;
        }

        System.out.println("\n You have selected the question for price: " + selectedQuestion.getPrice() + "\n");
        System.out.println("\n Selected Question : " + selectedQuestion.getQuestionText() + "\n");
        selectedQuestion.displayOptions();

        turnManager.setChosenQuestion(selectedQuestion);
        return true;
    }
}
