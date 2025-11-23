package comp3607.asg;

import java.util.HashMap;
import java.util.Map;

public class Question implements Questionable {

    private String questionText;
    private String answer;
    private int price;
    private Map<String, String> options = new HashMap<>();
    private boolean reuse = false;

   
    public Question(String q, String a) {
        this.questionText = q;
        this.answer = a;
    }

    // Setter for price (JSON "Value")
    public void setPrice(int price) {
        this.price = price;
    }

    // Setter for an option (A, B, C, D)
    public void addOption(String key, String value) {
        this.options.put(key, value);
    }

    @Override
    public String getQuestionText() {
        return this.questionText;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public Map<String, String> getOptions() {
        return this.options;
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }

    @Override
    public boolean isUsed() {
        return reuse;
    }

    // Mark when a question is used in the game
    public void markUsed() {
        this.reuse = true;
    }

    @Override
    public String checkCorrect(String userAnswer) {
        if (this.answer.equalsIgnoreCase(userAnswer.trim())) {
            return "Correct!";
        } else {
            return "Incorrect. Correct answer: " + this.answer;
        }
    }
}
