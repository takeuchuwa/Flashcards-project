import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int numberOfWords = Integer.parseInt(reader.readLine());
            HashSet<String> knownWords = new HashSet<>();
            for (int i = 0; i < numberOfWords; i++) {
                knownWords.add(reader.readLine().toLowerCase());
            }
            int countOfLines = Integer.parseInt(reader.readLine());
            LinkedHashSet<String> erroneous = new LinkedHashSet<>();
            for (int i = 0; i < countOfLines; i++) {
                String text = reader.readLine();
                String[] wordsOfText = text.split("\\s+");
                for (String s : wordsOfText) {
                    if (!knownWords.contains(s.toLowerCase())) {
                        erroneous.add(s);
                    }
                }
            }
            knownWords.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}