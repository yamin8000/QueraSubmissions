import java.util.Scanner;

public class Palindrome_308 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var isPalindrome = isPalindrome(scanner.nextLine().replaceAll("\\W", "").toLowerCase());
        if (isPalindrome) System.out.println("YES");
        else System.out.println("NO");
    }

    public static boolean isPalindrome(CharSequence input) {
        var length = input.length();
        if (length <= 1)
            return true;
        return input.charAt(0) == input.charAt(length - 1) && isPalindrome(input.subSequence(1, length - 1));
    }
}