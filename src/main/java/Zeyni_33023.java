import java.util.Arrays;
import java.util.Scanner;

public class Zeyni_33023 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        var array = new int[n][m];
        for (int i = 0; i < n; i++) {
            array[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int s = 0;
        if (n >= 3 && m >= 3) {
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    int x = array[i][j];
                    var a = x > array[i - 1][j] && x > array[i + 1][j] && x < array[i][j - 1] && x < array[i][j + 1];
                    var b = x > array[i][j - 1] && x > array[i][j + 1] && x < array[i - 1][j] && x < array[i + 1][j];
                    if (a || b) {
                        s++;
                    }
                }
            }
            System.out.println(s);
        } else System.out.println("0");
    }
}
