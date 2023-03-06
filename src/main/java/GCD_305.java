import java.math.BigInteger;
import java.util.Scanner;

public class GCD_305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String m = scanner.nextLine();

        BigInteger bigN = new BigInteger(n);
        BigInteger bigM = new BigInteger(m);

        System.out.println(gcd(bigN, bigM));
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) return a;
        else return gcd(b, a.mod(b));
    }
}
