// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long result = a;
        for (int i = a + 1; i < b; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}