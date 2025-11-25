package comp3607.asg;

public class TurnSummary {

private String playerName;
private String category;
private int questionValue;
private String questionText;
private String answerGiven;
private boolean correct;
private int pointsEarned;
private int runningTotal;
private int turnNumber;

public TurnSummary() {
    this.playerName = "";
    this.category = "";
    this.questionValue = 0;
    this.questionText = "";
    this.answerGiven = "";
    this.correct = false;
    this.pointsEarned = 0;
    this.runningTotal = 0;
    this.turnNumber = 0;
}

public void setPlayerName(String playerName) {
    this.playerName = playerName;
}

public void setCategory(String category) {
    this.category = category;
}

public void setQuestionValue(int questionValue) {
    this.questionValue = questionValue;
}

public void setQuestionText(String questionText) {
    this.questionText = questionText;
}

public void setAnswerGiven(String answerGiven) {
    this.answerGiven = answerGiven;
}

public void setCorrect(boolean correct) {
    this.correct = correct;
}

public void setPointsEarned(int pointsEarned) {
    this.pointsEarned = pointsEarned;
}

public void setRunningTotal(int runningTotal) {
    this.runningTotal = runningTotal;
}

public void setTurnNumber(int turnNumber) {
    this.turnNumber = turnNumber;
}

public String getPlayerName() {
    return playerName;
}

public String getCategory() {
    return category;
}

public int getQuestionValue() {
    return questionValue;
}

public String getQuestionText() {
    return questionText;
}
public String getAnswerGiven() {
    return answerGiven;
}

public boolean isCorrect() {
    return correct;
}
public int getPointsEarned() {
    return pointsEarned;
}
public int getRunningTotal() {
    return runningTotal;
}
public int getTurnNumber() {
    return turnNumber;
}

}
