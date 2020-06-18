import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = new String();
        int x;
        while (true) {
            try {
                input = reader.readLine();
                x = Integer.parseInt(input);
                if (x == 0) {
                    break;
                }
                System.out.println(x * 10);
            } catch (IOException | NumberFormatException e) {
                System.out.println("Invalid user input: " + input);
            }
        }
    }
}