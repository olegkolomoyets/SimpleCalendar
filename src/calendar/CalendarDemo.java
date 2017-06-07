package calendar;

import calendar.render.Input;
import calendar.render.Output;

import java.io.IOException;

public class CalendarDemo {
    public static void main(String[] args) throws IOException {


        CalendarEngine eng = Input.take();


        eng.addEvent(new Event("2017-01-06T10:00:00", "2017-01-18T10:00:00", "Memorial", "Room#2"));
        System.out.println(eng.isOccupied("Room#2", "2017-01-07T10:00:00"));
//
//        System.out.println(eng.getEventsByLocation("Room#2"));
//        System.out.println(eng.getEventsByLocation("Room#3"));

//        System.out.println(eng.getEventsByInterval("2017-01-01T10:00:00", "2017-01-31T10:00:00"));

//        eng.addEvent(new Event("2017-01-06T10:00:00", "2017-01-08T10:00:00", "Memorial15", "Room#3"));
//      eng.addEvent(new Event("2017-01-06T10:00:00", "Memorial5", "Room#3"));
//        eng.remove("2017-01-06T10:00:00");

//        System.out.println(eng.getEventsByLocation("Room#2"));
//        System.out.println(eng.getEventsByLocation("Room#3"));
//        System.out.println(eng.getEventsByInterval("2017-01-01T10:00:00", "2017-01-31T10:00:00"));

        Output.render();

    }
}
