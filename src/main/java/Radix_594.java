import java.util.Scanner;

public class Radix_594 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = Integer.parseInt(input.split(" ")[0]);
        int base = Integer.parseInt(input.split(" ")[1]);

        String out = convertFromBaseToBase(String.valueOf(number), 10, base);
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < out.length(); i++) {
            int charAt = Integer.parseInt(String.valueOf(out.charAt(i)));
            if (i % 2 == 0) sum1 += charAt;
            else sum2 += charAt;
        }
        if (sum1 == sum2) System.out.println("Yes");
        else System.out.println("No");
    }

    public static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }
}
