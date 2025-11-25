package comp3607.asg;

public class TurnManager {
    private Player currentPlayer;
    private int turnCount;
    private Questionable chosenQuestion ;
    private Categoryable chosenCategory ;
    private String chosenAnswer;
    private final Command answerCommand = new AnswerCommand();
    private final Command selectCategoryCommand = new SelectCategoryCommand();
    private final Command selectQuestionCommand = new SelectQuestionCommand();

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

    public Questionable getChosenQuestion() {
        return chosenQuestion;
    }

    public void setChosenQuestion(Questionable chosenQuestion) {
        this.chosenQuestion = chosenQuestion;
    }

    public Categoryable getChosenCategory() {
        return chosenCategory;
    }

    public void setChosenCategory(Categoryable chosenCategory) {
        this.chosenCategory = chosenCategory;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public TurnSummary PlayTurn(Player p, Board b) {

        nextTurn();
        setCurrentPlayer(p);
        System.out.println("Current turn : " + turnCount + " current player : " + this.getCurrentPlayer().getName() + "\n");
        
        
        PlayerConsole pc = new PlayerConsole(this, b);

        System.out.println("Current Score: " + this.getCurrentPlayer().getScore().getAmt() + "\n");

        System.out.println("\n Displaying Current Board... \n");

        b.displayBoard();

        System.out.println("\n Selecting Category...\n");
        pc.execute(selectCategoryCommand);

        System.out.println("\n Selecting Question Value...\n");
        pc.execute(selectQuestionCommand);

        System.out.println("\n Answering Question...\n");
        pc.execute(answerCommand);

       
        TurnSummary summary = new TurnSummary();
        
        summary.setPlayerName(this.getCurrentPlayer().getName());
        summary.setQuestionText(this.getChosenQuestion().getQuestionText());
        summary.setCategory(this.getChosenCategory().getCategory());
        summary.setQuestionValue(this.getChosenQuestion().getPrice());
        summary.setAnswerGiven(this.getChosenAnswer());
        summary.setCorrect(this.getChosenQuestion().checkCorrect(this.getChosenAnswer()));
        summary.setPointsEarned(this.getCurrentPlayer().getScore().getLastAdded());
        summary.setRunningTotal(this.getCurrentPlayer().getScore().getAmt());
        summary.setTurnNumber(turnCount);

        return summary;
    }




    
}
