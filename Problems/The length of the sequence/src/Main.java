import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int number;
        int count = 0;

        while (true) {
            number = Integer.parseInt(reader.readLine());
            if (number == 0) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}