package flashcards;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static boolean isRunning = true;


    public static void main(String[] args) throws IOException {
        Cards cards = new Cards();
        IOFile ioFile = new IOFile(cards);

        importCards(args, ioFile);
        while (isRunning) {
            ConsoleLog.outputMessage("Input the action (add, remove, import, export, ask, exit," +
                    "log, hardest card, reset stats):");
            String action = ConsoleLog.getInput();
            switch (action) {
                case "add":
                    cards.add();
                    break;
                case "remove":
                    cards.remove();
                    break;
                case "import":
                    ioFile.importFile();
                    break;
                case "export":
                    ioFile.exportFile();
                    break;
                case "ask":
                    cards.ask();
                    break;
                case "log":
                    ConsoleLog.log();
                    break;
                case "hardest card":
                    cards.hardestCard();
                    break;
                case "reset stats":
                    cards.resetStats();
                    break;
                case "exit":
                    exit(args, ioFile);
                    break;
            }
        }
    }

    private static void importCards(String[] args, IOFile ioFile) {
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0 && args[i].equals("-import")) {
                try {
                    ioFile.importFile(args[i + 1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void exit(String[] args, IOFile ioFile) {
        isRunning = false;
        ConsoleLog.outputMessage("Bye bye!");
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-export")) {
                ioFile.exportFile(args[i + 1]);
                break;
            }
        }
    }
}
