import java.util.Scanner;

public class DieHardPasswords_9772 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = 2 * (int) Math.pow(10, n - 1);
        int end = 8 * (int) Math.pow(10, n - 1) - 1;

        int firstDigitizer = (int) Math.pow(10, n - 1);

        for (int index = start; index <= end; index++) {
            int firstDigit = index / firstDigitizer;
            if (!isPrime(firstDigit)) continue;
            String number = String.valueOf(index);
            if (number.contains("0") || number.contains("4") || number.contains("6") || number.contains("8")) continue;
            if (isHardPrime(index))
                System.out.println(index);
        }
    }

    public static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2 || x == 3 || x == 5 || x == 7) return true;
        if (x % 2 == 0 || x % 3 == 0) return false;
        final int lastTrial = (int) Math.sqrt(x) + 1;
        int divisorsCount = 2;
        for (int index = 6; index <= lastTrial; index += 6) {
            if (divisorsCount > 2) break;
            if (x % (index + 1) == 0 || x % (index - 1) == 0) {
                divisorsCount++;
            }
        }
        return divisorsCount == 2;
    }

    public static boolean isHardPrime(int x) {
        if (x < 10) return isPrime(x);
        if (!isPrime(x)) return false;
        return isHardPrime(x / 10);
    }
}
