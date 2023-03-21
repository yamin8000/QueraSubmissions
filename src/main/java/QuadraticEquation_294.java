import java.util.Scanner;

public class QuadraticEquation_294 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var a = scanner.nextFloat();
        var b = scanner.nextFloat();
        var c = scanner.nextFloat();

        System.out.println(solve(a, b, c));
    }

    private static String solve(float a, float b, float c) {
        if (b == 0) return "IMPOSSIBLE";
        if (a == 0) return formatter(c / -b);
        var delta = delta(a, b, c);
        if (delta < 0) return "IMPOSSIBLE";
        else if (delta == 0) return formatter(-b / (2 * a));
        else if (delta > 0) {
            var x1 = (-b + Math.sqrt(delta)) / (2 * a);
            var x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return formatter((float) Math.min(x1, x2)) + "\n" + formatter((float) Math.max(x1, x2));
        } else return "IMPOSSIBLE";
    }

    private static String formatter(float x) {
        return String.format("%.3f", x);
    }

    private static float delta(float a, float b, float c) {
        return b * b - (4 * a * c);
    }
}
