
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println(new Scanner(System.in)
                .tokens()
                .filter(item -> Integer.parseInt(item) > 0).count() == 1);
    }
}