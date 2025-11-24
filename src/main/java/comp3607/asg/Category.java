package comp3607.asg;
import java.util.ArrayList;

public class Category implements Categoryable {

    
    private String category;
    private ArrayList<Question> questions = new ArrayList<>();

    public Category(String category) {
        this.category = category;
    }


    public String getCategory(){
        return this.category;
    }

    public ArrayList<Question> getQuestions(){
        return this.questions;
    }

     public void addQuestion(Question q) {
        this.questions.add(q);
    }

}
