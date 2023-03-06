import java.util.Arrays;
import java.util.Scanner;

public class DigitPrinter_9774 {

    public static void main(String... args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        printer(input);
    }

    private static void printer(String number) {
        var digits = number.toCharArray();
        for (char character : digits) {
            int[] out;
            var digit = Character.digit(character, 10);
            out = new int[digit];
            Arrays.fill(out, digit);
            System.out.print(digit + ": ");
            Arrays.stream(out).forEach(System.out::print);
            System.out.println();
        }
    }
}
