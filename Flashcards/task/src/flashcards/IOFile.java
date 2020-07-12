package flashcards;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class IOFile {
    private File file;
    private Cards cards;

    public IOFile(Cards cards) {
        this.cards = cards;
    }
    public void importFile(String pathForImport) throws IOException {
        file = new File(pathForImport);
        if (file.exists()) {
            int n = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String card = scanner.nextLine();
                String[] words = card.split("/");
                cards.setCards(words[0], words[1]);
                cards.setErrors(words[0], Integer.valueOf(words[2]));
                n++;

            }
            ConsoleLog.outputMessage(n + " cards have been loaded.");
        } else {
            ConsoleLog.outputMessage("File not found.");
        }

    }

    public void importFile() throws IOException {
        String pathForImport;
        ConsoleLog.outputMessage("File name:");
        pathForImport = ConsoleLog.getInput();
        importFile(pathForImport);
    }

    public void exportFile() throws IOException {
        String pathForExport;
        ConsoleLog.outputMessage("File name:");
        pathForExport = ConsoleLog.getInput();
        exportFile(pathForExport);
    }

    public void exportFile(String pathForExport) {
        file = new File(pathForExport);
        try (PrintWriter writer = new PrintWriter(file)) {
            int n = 0;
            for (Map.Entry<String, String> card : cards.getCards().entrySet()) {
                for (Map.Entry<String, Integer> error : cards.getErrors().entrySet()) {
                    if (card.getKey().equals(error.getKey())) {
                        writer.printf("%s/%s/%d\n", card.getKey(), card.getValue(), error.getValue());
                        n++;
                    }
                }
            }
            ConsoleLog.outputMessage(n + " cards have been saved.");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}
