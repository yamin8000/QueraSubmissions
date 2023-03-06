import java.util.Scanner;

public class DiamondPrinter_618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int _2nPlus1 = (2 * n) + 1;

        int stars = -1;
        boolean goingDown = false;
        for (int i = 0; i < _2nPlus1; i++) {
            if (stars == _2nPlus1) goingDown = true;
            if (stars == _2nPlus1 || goingDown) stars -= 2;
            else stars += 2;
            int spaces = _2nPlus1 - stars;
            int halfSpaces = spaces / 2;
            printSpaces(halfSpaces);
            printStars(stars);
            printSpaces(halfSpaces);
            System.out.println();
        }
    }


    private static void printStars(int x) {
        for (int i = 0; i < x; i++) System.out.print("*");
    }

    private static void printSpaces(int x) {
        for (int i = 0; i < x; i++) System.out.print(" ");
    }
}
