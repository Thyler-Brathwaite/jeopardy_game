package comp3607.asg;

import java.time.LocalDateTime;

public interface Command {

    
public void execute();

public void undo();

public LocalDateTime getTimeStamp();

}