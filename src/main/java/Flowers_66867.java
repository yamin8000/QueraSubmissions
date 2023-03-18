import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Flowers_66867 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var nm = scanner.nextLine().split(" ");
        var n = Integer.parseInt(nm[0]);
        var m = Integer.parseInt(nm[1]);

        var flowers = new ArrayList<String>();

        for (int i = 0; i < m; i++) {
            flowers.add(scanner.nextLine());
        }

        System.out.println(finder(flowers, n));
    }

    private static String finder(List<String> flowers, int n) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            boolean temp = false;
            for (String flower : flowers) {
                temp ^= !(flower.charAt(i) == 'B');
            }
            if (temp) out.append("F");
            else out.append("B");
        }

        return out.toString();
    }
}
