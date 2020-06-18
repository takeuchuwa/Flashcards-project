// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sequence = new int[n];
        for(int i = 0; i < sequence.length; i++) {
            sequence[i] = scanner.nextInt();
        }
        int max = 0;
        for(int i:sequence) {
            if(i > max && i % 4 == 0)
                max = i;
        }
        System.out.println(max);
    }
}