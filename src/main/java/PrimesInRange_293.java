import java.util.Scanner;

public class PrimesInRange_293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) System.out.println(i);
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
