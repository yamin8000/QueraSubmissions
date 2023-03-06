import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class BigNumbersSum_637 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        ArrayList<BigInteger> biggies = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(n); i++) {
            biggies.add(new BigInteger(scanner.nextLine()));
        }
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger big : biggies) {
            sum = sum.add(big);
        }
        System.out.println(sum);
    }
}
