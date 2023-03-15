import java.util.Scanner;

public class NumbersSumAndLength_276 {
    public static void main(String... args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine().split(" ");
        var m = Integer.parseInt(input[0]);
        var s = Integer.parseInt(input[1]);

        var min = findMin(m, s);
        var max = findMax(m, s);
        if (min.equals("-1") || max.equals("-1"))
            System.out.println("-1 -1");
        else System.out.println(findMin(m, s) + " " + findMax(m, s));
    }

    private static String findMin(int m, int s) {
        var builder = new StringBuilder();
        String temp = handleSpecificCases(m, s);
        if (temp != null) return temp;

        int a = 1;
        for (int i = 0; i < m; i++) {
            if (s < 10) builder.append(s);
            else {
                while (s - a > 9 && a < 10) a++;
                builder.append(a);
            }
            s -= a;
        }
        return builder.toString();
    }

    private static String findMax(int m, int s) {
        var builder = new StringBuilder();
        String temp = handleSpecificCases(m, s);
        if (temp != null) return temp;

        for (int i = 0; i < m; i++) {
            builder.append(Math.min(s, 9));
            if (s < 10) s = 0;
            else s -= 9;
        }
        return builder.toString();
    }

    private static String handleSpecificCases(int m, int s) {
        if (m == 1 && s == 0) return "0";
        if (s == 0) return "-1";
        if (s % m == 0) return String.valueOf(s / m).repeat(m);
        return null;
    }
}
