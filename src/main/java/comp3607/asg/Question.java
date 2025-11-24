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

  
    public void setPrice(int price) {
        this.price = price;
    }

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

    void setValue(int value) {
        this.price = value;
    }
}
