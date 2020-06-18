import java.util.ArrayList;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            numbers.add(Integer.parseInt(args[i]));
        }
        switch (operator) {
            case "MAX":
                int max = numbers.get(0);
                for (Integer number : numbers) {
                    if (number > max) {
                        max = number;
                    }
                }
                System.out.println(max);
                break;
            case "MIN":
                int min = numbers.get(0);
                for (Integer number : numbers) {
                    if (number < min) {
                        min = number;
                    }
                }
                System.out.println(min);
                break;
            case "SUM":
                int sum = 0;
                for (Integer number : numbers) {
                    sum += number;
                }
                System.out.println(sum);
                break;
        }
    }
}