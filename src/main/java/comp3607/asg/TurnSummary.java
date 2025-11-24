package comp3607.asg;

public class TurnSummary {

private String playerName;
private String category;
private String questionValue;
private String questionText;
private String answerGiven;
private boolean correct;
private String pointsEarned;
private String runningTotal;
private String turnNumber;

public TurnSummary() {
    this.playerName = "";
    this.category = "";
    this.questionValue = "";
    this.questionText = "";
    this.answerGiven = "";
    this.correct = false;
    this.pointsEarned = "";
    this.runningTotal = "";
    this.turnNumber = "";
}

public void setlayerName(String playerName) {
    this.playerName = playerName;
}

public void setCategory(String category) {
    this.category = category;
}

public void setQuestionValue(String questionValue) {
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

public void setPointsEarned(String pointsEarned) {
    this.pointsEarned = pointsEarned;
}

public void setRunningTotal(String runningTotal) {
    this.runningTotal = runningTotal;
}

public void setTurnNumber(String turnNumber) {
    this.turnNumber = turnNumber;
}

public String getPlayerName() {
    return playerName;
}

public String getCategory() {
    return category;
}

public String getQuestionValue() {
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
public String getPointsEarned() {
    return pointsEarned;
}
public String getRunningTotal() {
    return runningTotal;
}
public String getTurnNumber() {
    return turnNumber;
}

}
