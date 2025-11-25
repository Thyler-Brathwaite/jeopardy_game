package comp3607.asg;

import java.util.ArrayList;

public interface Categoryable {

    public String getCategory();

    public ArrayList<Question> getQuestions();

    public void addQuestion(Question q);

    public Question findQuestion(int price);

    public void removeQuestion(Question q);

    public void displayQuestionsPrices();
   
}
