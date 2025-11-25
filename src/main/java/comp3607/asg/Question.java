package comp3607.asg;

import java.util.HashMap;
import java.util.Map;

public class Question implements Questionable {

    private final String questionText;
    private final String answer;
    private int price;
    private final Map<String, String> options = new HashMap<>();
    private boolean reuse = false;

   
    public Question(String q, String a) {
        this.questionText = q;
        this.answer = a;
    }

  
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
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
    public boolean checkCorrect(String userAnswer) {
        if (this.answer.equalsIgnoreCase(userAnswer.trim())) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect! The correct answer was: " + this.answer);
            return false;
        }
    }

    @Override
    public void displayOptions() {
        for (Map.Entry<String, String> entry : options.entrySet()) {
            System.out.println("\n" + entry.getKey() + ": " + entry.getValue()+ "\n") ;
        }

    }
      
}
