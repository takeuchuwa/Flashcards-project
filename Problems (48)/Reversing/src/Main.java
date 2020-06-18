// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int hundred = number / 100;
        int decimal = number % 100 / 10;
        int ones = number % 100 % 10;
        if (ones == 0 && decimal == 0) {
            System.out.println(hundred);
        } else if (ones == 0) {
            System.out.println(decimal + "" + hundred);
        } else {
            System.out.println(ones + "" + decimal + "" + hundred);
        }
    }
}