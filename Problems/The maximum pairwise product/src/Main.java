import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lengthOfArray = sc.nextInt();
        int[] array = new int[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            array[i] = sc.nextInt();
        }
        int multiply = array[0] * array[1];

        for (int i = 0; i < lengthOfArray - 1; i++) {
            final int i1 = array[i] * array[i + 1];
            if (i1 > multiply) {
                multiply = i1;
            }
        }

        System.out.println(multiply);
    }
}