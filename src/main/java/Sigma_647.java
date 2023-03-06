import java.util.Scanner;

public class Sigma_647 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int sum = 0;

        for (int i = -10; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum += ((i + j) * (i + j) * (i + j)) / (j * j);
            }
        }
        System.out.println(sum);
    }
}
