package comp3607.asg;

public class SelectQuestionCommand implements Command {
    private String question;

    public void SetQuestion(String question) {
        this.question = question;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void undo() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public java.time.LocalDateTime getTimeStamp() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
