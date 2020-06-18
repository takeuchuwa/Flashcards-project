import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfCompanies = sc.nextInt();
        int[] yearlyIncomes = new int[numberOfCompanies];
        int[] individualTaxes = new int[numberOfCompanies];
        for (int i = 0; i < numberOfCompanies; i++) {
            yearlyIncomes[i] = sc.nextInt();
        }

        for (int i = 0; i < numberOfCompanies; i++) {
            individualTaxes[i] = sc.nextInt();
        }
        int count = 0;
        int taxes = 0;
        for (int i = 0; i < numberOfCompanies; i++) {
            if (individualTaxes[i] * yearlyIncomes[i] > taxes) {
                count = i + 1;
                taxes = individualTaxes[i] * yearlyIncomes[i];
            }
        }

        System.out.println(count);
    }
}