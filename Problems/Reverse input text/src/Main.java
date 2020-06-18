import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] arrOfCharacter = new char[50];
            int charAsNumber = reader.read();
            for (int i = 0; i < arrOfCharacter.length && charAsNumber != -1; i++) {
                char character = (char) charAsNumber;
                arrOfCharacter[i] = character;
                charAsNumber = reader.read();
            }
            for (int i = arrOfCharacter.length - 1; i >= 0; i--) {
                if (arrOfCharacter[i] != 0) {
                    System.out.print(arrOfCharacter[i]);
                }
            }
        }
    }
}