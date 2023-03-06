import java.util.Scanner;

public class GoodNumber_66861 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divisor = scanner.nextInt();
        long i = 1;
        long j = i;
        while (true) {
            long naturalDivisors = naturalDivisors(j);
            if (naturalDivisors >= divisor) {
                System.out.println(j);
                break;
            }
            j += i + 1;
            i++;
        }
    }

    private static long naturalDivisors(long n) {
        if (n <= 2) return n;
        int count = 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }
}
