package flashcards;

import java.io.IOException;
import java.util.*;

public class Cards {

    private LinkedHashMap<String, String> cards = new LinkedHashMap<>();
    private LinkedHashMap<String, Integer> errors = new LinkedHashMap<>();
    private Random random = new Random();

    public void ask() throws IOException {
        ConsoleLog.outputMessage("How many times to ask?");
        int n = Integer.parseInt(ConsoleLog.getInput());
        List<String> keysAsArray = new ArrayList<>(cards.keySet());
        for (int i = 0; i < n; i++) {
            String key = keysAsArray.get(random.nextInt(keysAsArray.size()));
            ConsoleLog.outputMessage("Print the definition of \"" +
                    key + "\":");
            String answer = ConsoleLog.getInput();
            if (cards.get(key).equals(answer)) {
                ConsoleLog.outputMessage("Correct answer.");
            } else if (getKey(cards, answer) != null) {
                ConsoleLog.outputMessage("Wrong answer. The correct one is \"" + cards.get(key) +
                        "\", you've just written the definition of \"" +
                        getKey(cards, answer) + "\".");
                if (errors.putIfAbsent(key, 1) == null) {
                    errors.put(key, 1);
                } else {
                    int errorsCount = errors.get(key);
                    errors.put(key, errorsCount + 1);
                }
            } else {
                ConsoleLog.outputMessage("Wrong answer. The correct one is \"" +
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

    public void resetStats() {
        errors.replaceAll((k, v) -> 0);
        ConsoleLog.outputMessage("Card statistics has been reset.");
    }

    public void hardestCard() {
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
            ConsoleLog.outputMessage("There are no cards with errors.");
        } else if (cardsWithErrors.size() == 1) {
            if (errorNumber == 1) {
                ConsoleLog.outputMessage("The hardest card is \"" + cardsWithErrors.get(0) + "\". " +
                        "You have " + 1 + " error answering it.");
            } else {
                ConsoleLog.outputMessage("The hardest card is \"" + cardsWithErrors.get(0) + "\". " +
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
            ConsoleLog.outputMessage(line.toString());
        }
    }

    public void add() throws IOException {
        String card;
        String definition;
        ConsoleLog.outputMessage("The card:");
        card = ConsoleLog.getInput();
        if (cards.containsKey(card)) {
            ConsoleLog.outputMessage("The card \"" + card + "\" already exists.");
            return;
        }
        ConsoleLog.outputMessage("The definition of the card:");
        definition = ConsoleLog.getInput();
        if (cards.containsValue(definition)) {
            ConsoleLog.outputMessage("The definition \"" + definition + "\" already exists.");
            return;
        }
        cards.put(card, definition);
        ConsoleLog.outputMessage("The pair (\"" + card + "\":\"" + definition + "\") has been added.");
    }

    public void remove() throws IOException {
        String card;
        ConsoleLog.outputMessage("The card:");
        card = ConsoleLog.getInput();
        if (cards.containsKey(card)) {
            cards.remove(card);
            errors.remove(card);
            ConsoleLog.outputMessage("The card has been removed.");
        } else {
            ConsoleLog.outputMessage("Can't remove \"" + card + "\": there is no such card.");
        }
    }

    public <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    public LinkedHashMap<String, String> getCards() {
        return cards;
    }

    public LinkedHashMap<String, Integer> getErrors() {
        return errors;
    }

    public void setCards(String card, String definition) {
        this.cards.put(card, definition);
    }

    public void setErrors(String card, Integer errors) {
        this.errors.put(card, errors);
    }
}
