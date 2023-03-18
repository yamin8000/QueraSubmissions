import java.util.Scanner;

public class SpecialSquare_296 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();

        System.out.println(printer(n));
    }


    private static String printer(int n) {
        var builder = new StringBuilder();
        if (n == 1) return "#";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean quarter = j > n - i - 1 && i <= j;
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1 || i == j || j == n - i - 1 || quarter)
                    builder.append("#");
                else builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
