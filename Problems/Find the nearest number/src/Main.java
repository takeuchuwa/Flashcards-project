import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> arr = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        int n = scanner.nextInt();
        Collections.sort(arr);
        int delta = arr.stream().map(x -> Math.abs(x - n))
                .min(Comparator.naturalOrder()).get();
        arr.removeIf(x -> Math.abs(n - x) > delta);
        arr.forEach(x -> System.out.print(x + " "));
    }
}