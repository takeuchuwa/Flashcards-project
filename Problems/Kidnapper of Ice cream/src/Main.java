import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> availableWords = Arrays
                .stream(scanner.nextLine().trim().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String[] note = scanner.nextLine().trim().split("\\s+");
        boolean isNoteAvailable = false;
        for (String noteWord : note) {
            boolean isWordAvailable = false;
            for (int i = 0; i < availableWords.size(); i++) {
                if (noteWord.equals(availableWords.get(i))) {
                    availableWords.remove(i);
                    i--;
                    isWordAvailable = true;
                    break;
                }
            }
            if (!isWordAvailable) {
                isNoteAvailable = false;
                break;
            } else {
                isNoteAvailable = true;
            }
        }

        System.out.println(isNoteAvailable ? "You get money" : "You are busted");
    }
}