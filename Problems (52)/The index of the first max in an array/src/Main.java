// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int maximumIndex = 0;
        int maximumNumber = scanner.nextInt();
        for (int i = 1; i < length; i++) {
            int number = scanner.nextInt();
            if (number > maximumNumber) {
                maximumIndex = i;
                maximumNumber = number;
            }
        }
        System.out.println(maximumIndex);
    }
}