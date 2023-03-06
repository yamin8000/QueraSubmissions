import java.util.Scanner;

public class Modulus_592 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        StringBuilder out = new StringBuilder();

        int bound = n - m;
        if (bound < 0) bound *= -1;

        for (int i = 2; i <= bound; i++) {
            if (bound % i == 0) out.append(i).append(" ");
        }
        System.out.println(out.toString().trim());
    }
}
