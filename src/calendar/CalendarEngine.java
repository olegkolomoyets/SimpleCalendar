package calendar;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CalendarEngine implements Calendar {

    public static TreeMap<LocalDateTime, Event> map = new TreeMap<LocalDateTime, Event>();
    private HashMap<String, Map<LocalDateTime, Event>> eventsByLocation = new HashMap<>();

    @Override
    public void addEvent(Event event) {

        Event replaced = map.put(event.startTime, event);

        if (replaced != null) {
            Map<LocalDateTime, Event> eventMap = eventsByLocation.get(replaced.location);
            eventMap.remove(replaced.startTime);
        }
        if (!eventsByLocation.containsKey(event.location)) {
            Map<LocalDateTime, Event> list = new HashMap<>();
            list.put(event.startTime, event);
            eventsByLocation.put(event.location, list);
        } else {
            eventsByLocation.get(event.location).put(event.startTime, event);
        }
    }

    @Override
    public List<Event> getEventsByInterval(String from, String to) {
        LocalDateTime timeFrom = LocalDateTime.parse(from);
        LocalDateTime timeTo = LocalDateTime.parse(to);

        SortedMap<LocalDateTime, Event> mapFromTo = map.subMap(timeFrom, timeTo);

        List<Event> list = mapFromTo.values().stream().collect(Collectors.toList());

        return list;
    }

    @Override
    public boolean isOccupied(String location, String startTime) {
        boolean occupied = false;
        LocalDateTime time = LocalDateTime.parse(startTime);
        if (eventsByLocation.containsKey(location)) {
            Collection<Event> values = eventsByLocation.get(location).values();
            for (Event event : values) {
                if (!time.isBefore(event.startTime) && !time.isAfter(event.endTime)) {
                    occupied = true;
                    break;
                }
            }
        }
        return occupied;
    }

    @Override
    public List<Event> getEventsByLocation(String location) {
        List<Event> list = new LinkedList<Event>();
        if (eventsByLocation.containsKey(location))
            list.addAll(eventsByLocation.get(location).values());
        return list;
    }

    @Override
    public void remove(String startTime) {
        LocalDateTime time = LocalDateTime.parse(startTime);

        Event removed = map.remove(time);

        Map<LocalDateTime, Event> event = eventsByLocation.get(removed.location);
        event.remove(time);

    }
}