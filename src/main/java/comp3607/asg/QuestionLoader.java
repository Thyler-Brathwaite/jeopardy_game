package comp3607.asg;

public abstract class QuestionLoader {

    protected String filepath;
    protected String rawData;

    public QuestionLoader(String filepath) {
        this.filepath = filepath;
    }

   
    public final Category loadQuestions() {
        ReadFile();        
        ParseData();        
        return LoadCategory();
    }

  
    protected abstract void ReadFile();
    protected abstract void ParseData();
    protected abstract Category LoadCategory();
}
