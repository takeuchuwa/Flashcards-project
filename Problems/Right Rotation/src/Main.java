import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rotation = sc.nextInt();
        int rightRotation = rotation % array.length;
        for (int i = 0; i < rightRotation; i++) {
            int temp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}