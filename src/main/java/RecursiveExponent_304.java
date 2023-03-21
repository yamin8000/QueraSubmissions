import java.text.DecimalFormat;
import java.util.Scanner;

public class RecursiveExponent_304 {
    public static void main(String[] args) {
        var format = new DecimalFormat("0.000");
        var scanner = new Scanner(System.in);
        var base = Double.parseDouble(scanner.nextLine());
        var expo = Integer.parseInt(scanner.nextLine());
        System.out.println(format.format(power(base, expo)));
    }

    private static double power(double base, int expo) {
        if (base == 1) return 1;
        if (expo == 1) return base;
        else return base * power(base, expo - 1);
    }
}
