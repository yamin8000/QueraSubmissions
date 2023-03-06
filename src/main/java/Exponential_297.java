import java.util.Scanner;

public class Exponential_297 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();

        float sum = 0.0f;
        if (x != 0 && n != 0) {
            for (int i = 0; i < n; i++) {
                sum += Math.pow(x, i) / factorial(i);
            }
        } else sum = 1;

        System.out.println(format(sum));
    }

    private static String format(float f) {
        return String.format(java.util.Locale.US, "%.3f", f);
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
