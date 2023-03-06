import java.util.Scanner;

public class Tiling_605 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        return n <= 3 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }
}
