package comp3607.asg;

import java.util.Map;

public class Question implements Questionable{

    private String questionText;
    private String answer;
    private int price;
    private Map<String,String> options;
    private boolean reuse;

    public String getQuestionText(){
        return this.questionText;
    }

    public int getPrice(){
        return this.price;
    }

    @Override
    public Map<String,String> getOptions(){
        return this.options;
    }

    @Override
    public String getAnswer() {    
        return this.answer;
    }

    @Override
    public boolean isUsed() {
        throw new UnsupportedOperationException("Unimplemented method 'isUsed'");
    }
    
}
