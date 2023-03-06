import java.util.Scanner;

public class ReverseFibonacci_303 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nPlus = scanner.nextInt();

        reverseFibonacci(n, nPlus);
    }

    private static void reverseFibonacci(long n, long nPlus) {
        System.out.println(n);
        if (nPlus - n > 0) reverseFibonacci(nPlus - n, n);
    }
}
