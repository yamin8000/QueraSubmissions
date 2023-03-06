import java.util.Scanner;

import static java.lang.Math.sqrt;

public class PrimeFinder_593 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = numSum(n);
        int i = 0;
        int temp = n + 1;
        int prime = 0;
        while (i != b) {
            if (isPrime(temp)) {
                i++;
            }
            prime = temp;
            temp++;
        }

        System.out.println(prime);
    }

    private static int numSum(int number) {
        int sum = 0;
        if (number < 0) return numSum(number * -1);
        else if (number < 10) return number;
        else {
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
        }
        return sum;
    }

    private static boolean isPrime(int number) {
        boolean isPrime = true;
        if (number < 2) return false;
        else if (number == 2) return true;
        else {
            for (int index = 2; index <= sqrt(number) + 1; index++) {
                if (number % index == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        }
    }
}