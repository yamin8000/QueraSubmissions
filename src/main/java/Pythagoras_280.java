import java.util.Scanner;

public class Pythagoras_280 {

    public static void main(String... args) {
        var scanner = new Scanner(System.in);
        var a = scanner.nextInt();
        var b = scanner.nextInt();
        var c = scanner.nextInt();

        System.out.println(pythagoras(a, b, c) ? "YES" : "NO");
    }

    private static boolean pythagoras(int a, int b, int c) {
        var temp = a * a == b * b + c * c;
        if (b > c) {
            if (a > b)
                return temp;
            else return b * b == a * a + c * c;
        } else {
            if (a > c)
                return temp;
            else return c * c == a * a + b * b;
        }
    }
}
