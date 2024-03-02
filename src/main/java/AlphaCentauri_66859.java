import java.util.Map;
import java.util.Scanner;

public class AlphaCentauri_66859 {

    private static final Map<Integer, String> numbers = Map.ofEntries(
            Map.entry(1, "1"),
            Map.entry(2, "2"),
            Map.entry(3, "3"),
            Map.entry(4, "4"),
            Map.entry(5, "5"),
            Map.entry(6, "6"),
            Map.entry(7, "7"),
            Map.entry(8, "8"),
            Map.entry(9, "9"),
            Map.entry(10, "A"),
            Map.entry(11, "B"),
            Map.entry(12, "C"),
            Map.entry(13, "D"),
            Map.entry(14, "E"),
            Map.entry(15, "F"));

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        System.out.println(radixConvert(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        scanner.close();
    }

    private static String radixConvert(int input, int radix) {
        if (input < radix) {
            if (radix <= 10)
                return String.valueOf(input);
            else
                return numbers.get(input);
        } else {
            StringBuilder builder = new StringBuilder();
            int divisor = input;
            while (divisor > 0) {
                if (divisor < radix) {
                    builder.append(divisor);
                    break;
                }
                int remainder = divisor % radix;
                if (remainder >= 10)
                    builder.append(numbers.get(remainder));
                else
                    builder.append(remainder);
                divisor /= radix;
            }
            return builder.reverse().toString();
        }
    }
}
