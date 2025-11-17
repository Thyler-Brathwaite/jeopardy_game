package comp3607.asg;

import java.util.Map;

public interface Questionable {
    
    public String getQuestionText();
    public int getPrice();
    public Map<String,String> getOptions();
    public String getAnswer();
    public boolean isUsed();
    public String checkCorrect(String answer);
}
