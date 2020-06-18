package flashcards;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static LinkedHashMap<String, String> cards = new LinkedHashMap<>();
    private static LinkedHashMap<String, Integer> errors = new LinkedHashMap<>();
    private static ArrayList<String> log = new ArrayList<>();
    private static boolean isRunning = true;
    private static final Random random = new Random();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0 && args[i].equals("-import")) {
                importFile(args[i + 1]);
            }
        }
        while (isRunning) {
            outputMsg("Input the action (add, remove, import, export, ask, exit," +
                    "log, hardest card, reset stats):");
            String action = getInput();
            switch (action) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "import":
                    importFile();
                    break;
                case "export":
                    exportFile();
                    break;
                case "ask":
                    ask();
                    break;
                case "log":
                    log();
                    break;
                case "hardest card":
                    hardestCard();
                    break;
                case "reset stats":
                    resetStats();
                    break;
                case "exit":
                    exit(args);
                    break;
            }
        }
    }

    private static void exit(String[] args) {
        isRunning = false;
        outputMsg("Bye bye!");
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-export")) {
                exportFile(args[i + 1]);
                break;
            }
        }
    }

    private static void resetStats() {
        for (String key : errors.keySet()) {
            errors.put(key, 0);
        }
        outputMsg("Card statistics has been reset.");
    }

    private static void hardestCard() {
        ArrayList<String> cardsWithErrors = new ArrayList<>();
        int errorNumber = 0;
        for (String key : errors.keySet()) {
            if (errors.get(key) > errorNumber) {
                cardsWithErrors.clear();
                errorNumber = errors.get(key);
                cardsWithErrors.add(key);
            } else if (errors.get(key) == errorNumber) {
                cardsWithErrors.add(key);
            }
        }

        if (errorNumber == 0) {
            outputMsg("There are no cards with errors.");
        } else if (cardsWithErrors.size() == 1) {
            if (errorNumber == 1) {
                outputMsg("The hardest card is \"" + cardsWithErrors.get(0) + "\". " +
                        "You have " + 1 + " error answering it.");
            } else {
                outputMsg("The hardest card is \"" + cardsWithErrors.get(0) + "\". " +
                        "You have " + errorNumber + " errors answering it.");
            }
        } else {
            StringBuilder line;
            line = new StringBuilder("The hardest cards are ");
            for (int i = 0; i < cardsWithErrors.size(); i++) {
                line.append("\"").append(cardsWithErrors.get(i)).append("\"");
                if (i == cardsWithErrors.size() - 1) {
                    line.append(". ");
                } else {
                    line.append(", ");
                }
            }
            if (errorNumber == 1) {
                line.append("You have " + 1 + " error answering it.");
            } else {
                line.append("You have ").append(errorNumber).append(" errors answering it.");
            }
            outputMsg(line.toString());
        }
    }

    private static void outputMsg(String line) {
        log.add(line);
        System.out.println(line);
    }

    private static String getInput() throws IOException {
        String line = reader.readLine();
        log.add(line);
        return line;
    }

    private static void log() throws IOException {
        String pathForLog;
        outputMsg("File name:");
        pathForLog = getInput();
        File file = new File(pathForLog);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String logLine : log) {
                writer.println(logLine);
            }
            outputMsg("The log has been saved.");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void add() throws IOException {
        String card;
        String definition;
        outputMsg("The card:");
        card = getInput();
        if (cards.containsKey(card)) {
            outputMsg("The card \"" + card + "\" already exists.");
            return;
        }
        outputMsg("The definition of the card:");
        definition = getInput();
        if (cards.containsValue(definition)) {
            outputMsg("The definition \"" + definition + "\" already exists.");
            return;
        }
        cards.put(card, definition);
        outputMsg("The pair (\"" + card + "\":\"" + definition + "\") has been added.");
    }

    public static void remove() throws IOException {
        String card;
        outputMsg("The card:");
        card = getInput();
        if (cards.containsKey(card)) {
            cards.remove(card);
            errors.remove(card);
            outputMsg("The card has been removed.");
        } else {
            outputMsg("Can't remove \"" + card + "\": there is no such card.");
        }
    }

    public static void importFile(String pathForImport) throws IOException {
        File file = new File(pathForImport);
        if (file.exists()) {
            int n = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String card = scanner.nextLine();
                String[] words = card.split("/");
                cards.put(words[0], words[1]);
                errors.put(words[0], Integer.valueOf(words[2]));
                n++;

            }
            outputMsg(n + " cards have been loaded.");
        } else {
            outputMsg("File not found.");
        }

    }

    public static void importFile() throws IOException {
        String pathForImport;
        outputMsg("File name:");
        pathForImport = getInput();
        File file = new File(pathForImport);
        if (file.exists()) {
            int n = 0;
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String card = scanner.nextLine();
                String[] words = card.split("/");
                cards.put(words[0], words[1]);
                errors.put(words[0], Integer.valueOf(words[2]));
                n++;

            }
            outputMsg(n + " cards have been loaded.");
        } else {
            outputMsg("File not found.");
        }

    }

    public static void exportFile(String pathForExport) {
        File file = new File(pathForExport);
        try (PrintWriter writer = new PrintWriter(file)) {
            int n = 0;
            for (Map.Entry<String, String> card : cards.entrySet()) {
                for (Map.Entry<String, Integer> error : errors.entrySet()) {
                    if (card.getKey().equals(error.getKey())) {
                        writer.printf("%s/%s/%d\n", card.getKey(), card.getValue(), error.getValue());
                        n++;
                    }
                }
            }
            outputMsg(n + " cards have been saved.");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void exportFile() throws IOException {
        String pathForExport;
        outputMsg("File name:");
        pathForExport = getInput();
        File file = new File(pathForExport);
        try (PrintWriter writer = new PrintWriter(file)) {
            int n = 0;
            for (Map.Entry<String, String> card : cards.entrySet()) {
                for (Map.Entry<String, Integer> error : errors.entrySet()) {
                    if (card.getKey().equals(error.getKey())) {
                        writer.printf("%s/%s/%d\n", card.getKey(), card.getValue(), error.getValue());
                        n++;
                    }
                }
            }
            outputMsg(n + " cards have been saved.");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void ask() throws IOException {
        outputMsg("How many times to ask?");
        int n = Integer.parseInt(getInput());
        List<String> keysAsArray = new ArrayList<>(cards.keySet());
        for (int i = 0; i < n; i++) {
            String key = keysAsArray.get(random.nextInt(keysAsArray.size()));
            outputMsg("Print the definition of \"" +
                    key + "\":");
            String answer = getInput();
            if (cards.get(key).equals(answer)) {
                outputMsg("Correct answer.");
            } else if (getKey(cards, answer) != null) {
                outputMsg("Wrong answer. The correct one is \"" + cards.get(key) +
                        "\", you've just written the definition of \"" +
                        getKey(cards, answer) + "\".");
                if (errors.putIfAbsent(key, 1) == null) {
                    errors.put(key, 1);
                } else {
                    int errorsCount = errors.get(key);
                    errors.put(key, errorsCount + 1);
                }
            } else {
                outputMsg("Wrong answer. The correct one is \"" +
                        cards.get(key) + "\".");
                if (errors.putIfAbsent(key, 1) == null) {
                    errors.put(key, 1);
                } else {
                    int errorsCount = errors.get(key);
                    errors.put(key, errorsCount + 1);
                }
            }
        }
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
