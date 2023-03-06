import java.util.Scanner;

public class FarzadWorkaholic_658 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbersInput = scanner.nextLine();
        String[] numbersStrings = numbersInput.split(" ");
        int[] numbers = new int[numbersStrings.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersStrings[i]);
        }
        System.out.println(bestSum(numbers));
    }

    private static int bestSum(int[] numbers) {
        int bestSum = 0;
        int currentSum = 0;
        for (int number : numbers) {
            currentSum = Integer.max(0, currentSum + number);
            bestSum = Integer.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
