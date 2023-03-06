import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Float_292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        List<Float> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            float newNum = scanner.nextFloat();
            numbers.add(newNum);
        }

        System.out.println("Max: " + format(numbers.stream().max(Float::compare).get()));
        System.out.println("Min: " + format(numbers.stream().min(Float::compare).get()));
        System.out.println("Avg: " + format(numbers.stream().reduce(0.0f, Float::sum) / n));
    }

    private static String format(float f) {
        return String.format(java.util.Locale.US, "%.3f", f);
    }
}
