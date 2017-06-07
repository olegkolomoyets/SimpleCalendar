package calendar;

import java.util.List;

interface Calendar {

    void addEvent(Event event);

    List<Event> getEventsByInterval(String from, String to);

    boolean isOccupied(String location, String startTime);

    List<Event> getEventsByLocation(String location);

    void remove(String startTime);
}
