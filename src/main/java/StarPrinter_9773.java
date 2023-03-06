import java.util.Scanner;

public class StarPrinter_9773 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int stars = -1;
        boolean goingDown = false;
        for (int i = 0; i < n; i++) {
            if (stars == n) goingDown = true;
            if (stars == n || goingDown) stars -= 2;
            else stars += 2;
            int spaces = n - stars;
            int halfSpaces = spaces / 2;
            printSpaces(halfSpaces);
            printStars(stars);
            printSpaces(halfSpaces);
            printSpaces(halfSpaces);
            printStars(stars);
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
