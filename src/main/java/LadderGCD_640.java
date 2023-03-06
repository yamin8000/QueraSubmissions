import java.math.BigInteger;
import java.util.Scanner;

public class LadderGCD_640 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String m = scanner.nextLine();

        BigInteger bigN = new BigInteger(n);
        BigInteger bigM = new BigInteger(m);

        System.out.println(gcd(bigN, bigM));
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.compareTo(BigInteger.ZERO) < 0) a = a.multiply(BigInteger.valueOf(-1));
        if (b.compareTo(BigInteger.ZERO) < 0) b = b.multiply(BigInteger.valueOf(-1));

        if (b.equals(BigInteger.ZERO)) return a;
        else return gcd(b, a.mod(b));
    }
}
