import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        int solutionCounts = 0;
        for (int i = 0; i <= 1000 && solutionCounts < 4; i++) {
            if (a * Math.pow(i, 3) + b * Math.pow(i, 2) + c * i + d == 0) {
                solutionCounts++;
                System.out.println(i);
            }
        }
    }
}