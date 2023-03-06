import java.util.*;

public class HallowSquare_283 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a <= b) System.out.println("Wrong order!");
        else if ((a - b) % 2 != 0) System.out.println("Wrong difference!");
        else {
            for (int i = 0; i < (a - b) / 2; i++) {
                printStar(a);
                System.out.println();
            }
            for (int i = 0; i < b; i++) {
                printStar((a - b) / 2);
                printSpaces();
                printStar((a - b) / 2);
                System.out.println();
            }
            for (int i = 0; i < (a - b) / 2; i++) {
                printStar(a);
                System.out.println();
            }
        }
    }

    private static void printStar(int x) {
        for (int j = 0; j < x; j++) {
            if (j != x - 1) System.out.print("* ");
            else System.out.print("*");
        }
    }

    private static void printSpaces() {
        for (int i = 0; i < 7; i++) System.out.print(" ");
    }
}
