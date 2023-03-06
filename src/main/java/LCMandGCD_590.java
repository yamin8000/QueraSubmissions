import java.math.BigInteger;
import java.util.Scanner;

public class LCMandGCD_590 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] nums = line.split(" ");

        BigInteger bigN = new BigInteger(nums[0]);
        BigInteger bigM = new BigInteger(nums[1]);

        System.out.println(gcd(bigN, bigM) + " " + lcm(bigM, bigN));
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) return a;
        else return gcd(b, a.mod(b));
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.divide(gcd(a, b)).multiply(b);
    }
}
