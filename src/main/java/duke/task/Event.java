package duke.task;

import duke.command.Command;

import java.util.Date;

public class Event extends Task {

    private Date eventTimeTo;
    private Date eventTimeFrom;


    public Event(String eventName, Date eventTimeTo, Date eventTimeFrom) {
        super(eventName);
        this.eventTimeFrom = eventTimeFrom;
        this.eventTimeTo = eventTimeTo;
    }

    @Override
    public String getTaskName() {
        return super.getTaskName() +
                " (at: " + Command.DATE_FORMAT.format(eventTimeFrom) + " - " + Command.DATE_FORMAT.format(eventTimeTo) + ")";
    }

    @Override
    public char getRepLetter() {
        return 'E';
    }

    @Override
    public String toDelimitedString() {
        return String.format("%c | %c | %s | %s | %s",
                this.getRepLetter(), this.isDone() ? 'T' : 'F', super.getTaskName(),
                Command.DATE_FORMAT.format(this.eventTimeFrom), Command.DATE_FORMAT.format(this.eventTimeTo));
    }

}
