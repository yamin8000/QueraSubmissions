import java.util.Scanner;

public class Factorial_589 {
    public static void main(String... args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextInt();
        System.out.println(factorial(input));
    }

    private static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Input should be bigger than zero");
        return n < 2 ? 1 : n * factorial(n - 1);
    }
}
