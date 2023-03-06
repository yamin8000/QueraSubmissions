import java.util.*;

public class PalindromeRadix_651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();

        String temp = convertFromBaseToBase(a, Integer.parseInt(b), Integer.parseInt(c));
        String res = "NO";
        if (temp.equals(new StringBuilder(temp).reverse().toString())) res = "YES";
        System.out.println(res);
    }

    public static String convertFromBaseToBase(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }
}
