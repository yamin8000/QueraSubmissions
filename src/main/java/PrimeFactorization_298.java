import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrimeFactorization_298 {

    private static final int n = 100;
    private static List<BigInteger> primes = primes(10);

    public static void main(String... args) {
        var scanner = new Scanner(System.in);
        var n = new BigInteger(scanner.nextLine());
        printFactors(n);

        /*for (int i = 1018081; i < Integer.MAX_VALUE; i++) {
            printFactors(BigInteger.valueOf(i));
        }*/
    }

    private static void printFactors(BigInteger n) {
        var factors = factorize(n);
        var groups = factors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var iterator = groups.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getValue() != 1)
                System.out.print(entry.getKey() + "^" + entry.getValue());
            else System.out.print(entry.getKey());
            if (iterator.hasNext())
                System.out.print("*");
        }
        System.out.println();
    }

    private static List<BigInteger> factorize(BigInteger number) {
        if (number.equals(BigInteger.ONE) || isPrime(number)) return List.of(number);
        var factors = new ArrayList<BigInteger>();
        var root = number.sqrt();
        var localPrimes = primes.stream().filter(i -> root.compareTo(i) >= 0).toList();

        Optional<BigInteger> target;
        for (BigInteger prime : localPrimes) {
            var dr = number.divideAndRemainder(prime);
            if (dr[1].equals(BigInteger.ZERO)) {
                factors.add(prime);
                if (isPrime(dr[0]))
                    factors.add(dr[0]);
                else factors.addAll(factorize(dr[0]));
            }
            target = factors.stream().reduce((x, ac) -> ac.multiply(x));
            if (target.isPresent() && target.get().equals(number))
                break;
        }
        if (factors.isEmpty() && !isPrime(number)) {
            BigInteger probablePrime = root;
            for (; root.compareTo(probablePrime) >= 0; probablePrime = probablePrime.subtract(BigInteger.ONE)) {
                if (isPrime(probablePrime)) {
                    var dr = number.divideAndRemainder(probablePrime);
                    if (dr[1].equals(BigInteger.ZERO)) {
                        factors.add(probablePrime);
                        if (isPrime(dr[0]))
                            factors.add(dr[0]);
                        else factors.addAll(factorize(dr[0]));
                    }
                    target = factors.stream().reduce((x, ac) -> ac.multiply(x));
                    if (target.isPresent() && target.get().equals(number))
                        break;
                }
            }
        }
        if (factors.isEmpty() && isPrime(number)) factors.add(number);
        return factors;
    }

    private static List<BigInteger> primes(int n) {
        var primes = new ArrayList<BigInteger>();
        for (BigInteger i = BigInteger.TWO; i.compareTo(BigInteger.valueOf(n)) <= 0; i = i.add(BigInteger.ONE)) {
            if (isPrime(i))
                primes.add(i);
        }
        return primes;
    }

    private static boolean isPrime(BigInteger number) {
        if (number.intValue() < 2) return false;
        var factors = 2;
        var root = number.sqrt();
        var startCursor = new BigInteger(String.valueOf(2));
        var endCursor = root;
        var firstHalfEndCursor = root.divide(BigInteger.TWO);
        var secondHalfStartCursor = firstHalfEndCursor.add(BigInteger.ONE);
        if (startCursor.compareTo(endCursor) < 0 && firstHalfEndCursor.compareTo(startCursor) > 0 && secondHalfStartCursor.compareTo(endCursor) < 0) {
            while (startCursor.compareTo(firstHalfEndCursor) <= 0 && secondHalfStartCursor.compareTo(endCursor) <= 0) {
                if (number.mod(startCursor).equals(BigInteger.ZERO))
                    factors++;
                if (factors > 2) return false;
                if (number.mod(endCursor).equals(BigInteger.ZERO))
                    factors++;
                if (factors > 2) return false;
                if (number.mod(firstHalfEndCursor).equals(BigInteger.ZERO))
                    factors++;
                if (factors > 2) return false;
                if (number.mod(secondHalfStartCursor).equals(BigInteger.ZERO))
                    factors++;
                if (factors > 2) return false;

                startCursor = startCursor.add(BigInteger.ONE);
                endCursor = endCursor.min(BigInteger.ONE);
                firstHalfEndCursor = firstHalfEndCursor.min(BigInteger.ONE);
                secondHalfStartCursor = secondHalfStartCursor.add(BigInteger.ONE);
            }
        } else {
            while (startCursor.compareTo(root) <= 0) {
                if (factors > 2) return false;
                if (number.mod(startCursor).equals(BigInteger.ZERO))
                    factors++;
                startCursor = startCursor.add(BigInteger.ONE);
            }
        }
        return factors == 2;
    }
}
