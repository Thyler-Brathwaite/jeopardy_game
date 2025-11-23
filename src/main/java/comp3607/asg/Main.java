package comp3607.asg;

public class Main {
    public static void main(String[] args) {

        JsonQuestionLoader loader = new JsonQuestionLoader("resources/sample_game_JSON.json");


        Board board = new Board();


        Category c = loader.loadQuestions();  
        while (c != null) {
            board.addCategory(c);
            c = loader.LoadCategory();
        }


        board.displayBoard();
    }
}
