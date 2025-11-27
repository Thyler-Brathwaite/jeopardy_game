package comp3607.asg;
import java.util.ArrayList;

public class Category implements Categoryable {

    
    private final String category;
    private final ArrayList<Question> questions;

    public Category(String category){ 
        this.category = category;
        this.questions = new ArrayList<>();
    }

    @Override
    public String getCategory(){
        return this.category;
    }
    @Override
    public ArrayList<Question> getQuestions(){
        return this.questions;
    }
    @Override
     public void addQuestion(Question q) {
        this.questions.add(q);
    }

    @Override
     public Question findQuestion(int price) {
        
       for (Question q : questions) {
        if (q.getPrice() == price && !q.isUsed()) {
            return q;
        }
    }
    
    System.out.println("No *available* question found for that price.");
    return null;
}


    @Override
    public void removeQuestion(Question q){
        this.questions.remove(q);
    }

    @Override
    public void displayQuestionsPrices(){
        System.out.println("Questions for category: " + this.category);
        for(Question q : questions){
            System.out.println("Price: " + q.getPrice());
        }
    }

    
    

}