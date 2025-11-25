package comp3607.asg;
import java.util.Scanner;

public class SelectCategoryCommand implements Command {
   
    private TurnManager turnManager = new TurnManager();
    private Scanner scanner ;
    private Board board;
    
   
    @Override
    public void SetupCommand(TurnManager t, Scanner s, Board b) {
        this.turnManager = t;
        this.scanner = s;
        this.board = b;

    }


    @Override
    public void execute() {
        System.out.println("Please select a category from the following options: ");
        String answer = scanner.nextLine();
        Categoryable selectedCategory = board.getCategoryByName(answer);
        if (selectedCategory != null) {
            System.out.println("You have selected the category: " + selectedCategory.getCategory());
        } else {
            System.out.println("Category not found. Please try again.");
        }

        turnManager.setChosenCategory(selectedCategory);
        
    }        
   

   
    

   
    
}
 