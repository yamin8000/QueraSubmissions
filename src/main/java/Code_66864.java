import java.util.Scanner;

public class Code_66864 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 5000; i++) stringBuilder.append(i);
        System.out.println(stringBuilder.toString().charAt(input));
    }
}