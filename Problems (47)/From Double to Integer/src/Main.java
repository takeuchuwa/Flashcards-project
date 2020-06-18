// Posted from EduTools plugin
import java.util.*;

public class Main {

    public static int convert(Double val) {
        if (val.isNaN()) {
            return 0;
        }

        if (val.isInfinite()) {
            if (val > 0) {
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }

        return val.intValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double doubleVal = new Double(scanner.nextDouble() / scanner.nextDouble());
        System.out.println(convert(doubleVal));
    }
}