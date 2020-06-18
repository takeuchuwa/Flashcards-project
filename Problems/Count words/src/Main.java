import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        int words = 0;
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n;
            boolean startWord = true;
            while ((n = reader.read()) != -1) {
                char c = (char) n;
                if (c != ' ' && startWord) {
                    words++;
                    startWord = false;
                } else if (c == ' ') {
                    startWord = true;
                }
            }
        }
        System.out.println(words);
    }

}