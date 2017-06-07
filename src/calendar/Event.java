package calendar;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Event {
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public String subject;
    public String location;
    public EventType type;

    public Event(String startTime, String endTime, String subject, String location) throws IOException {
        try {
            LocalDateTime.parse(startTime);
            LocalDateTime.parse(endTime);
        } catch (DateTimeParseException e) {
            throw new IOException("Bad time!");
        }
        this.startTime = LocalDateTime.parse(startTime);
        this.endTime = LocalDateTime.parse(endTime);
        this.subject = subject;
        this.location = location;
    }
}
