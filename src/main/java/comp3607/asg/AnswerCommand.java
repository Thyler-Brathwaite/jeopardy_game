package comp3607.asg;

public class AnswerCommand implements Command {
    
    private String answer;

    public void SetAnswer(String answer) {
        this.answer = answer;
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
