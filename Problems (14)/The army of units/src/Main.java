import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int totalArmy = scanner.nextInt();
        if (totalArmy >= 1 && totalArmy <= 19) {
            System.out.println("pack");
        } else if (totalArmy >= 20 && totalArmy <= 249) {
            System.out.println("throng");
        } else if (totalArmy >= 250 && totalArmy <= 999) {
            System.out.println("zounds");
        } else if (totalArmy >= 1000) {
            System.out.println("legion");
        } else
            System.out.println("no army");
    }
}