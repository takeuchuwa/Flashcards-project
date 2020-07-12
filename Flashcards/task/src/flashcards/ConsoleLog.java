package flashcards;

import java.io.*;
import java.util.ArrayList;

public class ConsoleLog {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<String> log = new ArrayList<>();


    public static void log() throws IOException {
        String pathForLog;
        outputMessage("File name:");
        pathForLog = getInput();
        File file = new File(pathForLog);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String logLine : log) {
                writer.println(logLine);
            }
            outputMessage("The log has been saved.");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
    public static void outputMessage(String line) {
        log.add(line);
        System.out.println(line);
    }
    public static String getInput() throws IOException {
        String line = reader.readLine();
        log.add(line);
        return line;
    }
}
