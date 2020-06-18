import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int year = Integer.parseInt(reader.readLine());
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println("Leap");
            } else {
                System.out.println("Regular");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}