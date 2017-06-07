package calendar.render;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

import static calendar.CalendarEngine.map;

public class Output {

    public static void render() throws IOException {
        final File newFile = new File("E:/Calendar.txt");
        try(final Writer writer = new FileWriter(newFile, false)) {

            for (LocalDateTime key : map.keySet()) {
                writer.write(String.valueOf(map.get(key).startTime) + ", " + String.valueOf(map.get(key).endTime) + ", " + map.get(key).subject + ", " + map.get(key).location);
                writer.write('\n');
            }
        } catch (IOException e) {
            System.out.println("Something gone wrong!");
        }
    }
}
