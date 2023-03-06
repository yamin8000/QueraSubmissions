import java.util.ArrayList;
import java.util.Scanner;

public class PrimesInRange_649 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = a + 1; i < b; i++) {
            if (isPrime(i)) list.add(i);
        }
        int listSize = list.size();
        for (int index = 0; index < listSize; index++) {
            System.out.print(list.get(index));
            if (index != listSize - 1) System.out.print(',');
        }
    }

    private static boolean isPrime(int number) {
        int numberOfPrimes = 2;
        if (number < 2) return false;
        else {
            for (int index = 2; index < (number / 2) + 1; index++) {
                if (number % index == 0) numberOfPrimes++;
            }
            return numberOfPrimes == 2;
        }
    }
}