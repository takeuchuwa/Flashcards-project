import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h1 = Integer.parseInt(scanner.nextLine());
        int m1 = Integer.parseInt(scanner.nextLine());
        int s1 = Integer.parseInt(scanner.nextLine());
        int h2 = Integer.parseInt(scanner.nextLine());
        int m2 = Integer.parseInt(scanner.nextLine());
        int s2 = Integer.parseInt(scanner.nextLine());
        int range = (h2 - h1) * 3600 + (m2 - m1) * 60 + (s2 - s1);
        System.out.println(range);
    }
}