package comp3607.asg;

import java.util.Map;

public interface Questionable {
    
    public String getQuestionText();
    public int getPrice();
    public void addOption(String optionKey, String optionText);
    public Map<String,String> getOptions();
    public String getAnswer();
    public boolean isUsed();
    public boolean checkCorrect(String answer);
    public void displayOptions();
}
