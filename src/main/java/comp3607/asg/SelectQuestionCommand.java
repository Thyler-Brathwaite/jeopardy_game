package comp3607.asg;

import java.util.Scanner;

public class SelectQuestionCommand implements Command {
    private TurnManager turnManager;
    private Scanner scanner ;
    private Board board;
    private String answer;
    
   
    @Override
    public void SetupCommand(TurnManager t, Scanner s, Board b) {
        this.turnManager = t;
        this.scanner = s;
        this.board = b;

    }

    @Override
    public void execute() {
        System.out.println("\n Please select a price from the chosen category : \n");
        answer = scanner.nextLine();
        Categoryable cat = turnManager.getChosenCategory();
        Questionable selectedQuestion = cat.findQuestion(Integer.parseInt(answer));
        if (selectedQuestion != null) {
            System.out.println("\n You have selected the question for price: " + selectedQuestion.getPrice() + "\n");
            System.out.println("\n Selected Question : " + selectedQuestion.getQuestionText() + "\n");
            selectedQuestion.displayOptions();
        } else {
            System.out.println("\n Question not found for that price. Please try again.\n");
        }
        turnManager.setChosenQuestion(selectedQuestion);


        
    }
    
    
    
}
