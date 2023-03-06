import java.util.Scanner;

public class Pythagoras_654 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        System.out.println(getSum(sum));
    }

    private static String getSum(int sum) {
        if (sum < 12) return "Impossible";
        int c;
        for (int i = 1; i < sum; i++) {
            for (int j = 1; j < sum; j++) {
                c = sum - i - j;
                if (isFisa(i, j, c)) return i + " " + j + " " + c;
            }
        }
        return "Impossible";
    }

    private static boolean isFisa(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        int max = Math.max(Math.max(a, b), c);
        if (max == a) return max * max == powers(b, c);
        if (max == b) return max * max == powers(a, c);
        return max * max == powers(a, b);
    }

    private static int powers(int a, int b) {
        return a * a + b * b;
    }
}
