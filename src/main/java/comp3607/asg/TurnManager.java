package comp3607.asg;

public class TurnManager {
    private Player currentPlayer;
    private int turnCount;
    private Question chosenQuestion ;
    private Category chosenCategory ;
    private String chosenAnswer;

    public TurnManager() {
        this.currentPlayer = null;
        this.turnCount = 0;
        this.chosenQuestion = null;
        this.chosenCategory = null;
        this.chosenAnswer = null;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void nextTurn() {
        this.turnCount++;
    }

    public Question getChosenQuestion() {
        return chosenQuestion;
    }

    public void setChosenQuestion(Question chosenQuestion) {
        this.chosenQuestion = chosenQuestion;
    }

    public Category getChosenCategory() {
        return chosenCategory;
    }

    public void setChosenCategory(Category chosenCategory) {
        this.chosenCategory = chosenCategory;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public TurnSummary PlayTurn() {
        
        return new TurnSummary();
    }




    
}
