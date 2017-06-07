package calendar.render;

import calendar.CalendarEngine;
import calendar.Event;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Input {
    public static CalendarEngine take() throws IOException {
        File file = new File("E:/Calendar.txt");
        final Scanner sc = new Scanner(file);
        CalendarEngine eng = new CalendarEngine();

        while (sc.hasNext()) {

            String line = sc.nextLine();

            String[] parts = line.split(", ");

            if (parts.length < 4) {
                throw new IOException("Bad Data!");
            } else {
                Event newEvent = new Event(parts[0], parts[1], parts[2], parts[3]);
                eng.addEvent(newEvent);
            }
        }

//        eng.addEvent(new Event("2017-01-06T10:00:00", "Memorial", "Room#2"));

        return eng;
    }
}
