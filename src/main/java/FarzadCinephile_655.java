import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FarzadCinephile_655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int filmCount = scanner.nextInt();
        ArrayList<String> filmNames = new ArrayList<>();
        for (int i = 0; i <= filmCount; i++) filmNames.add(i, scanner.nextLine());
        filmNames.remove(0);
        ArrayList<String> newFilmNames = new ArrayList<>();
        for (String filmName : filmNames) {
            String[] words = filmName.split(" ");
            StringBuilder newFilmName = new StringBuilder();
            for (String word : words) {
                String newWord = word.toLowerCase(Locale.ROOT);
                newFilmName.append(String.valueOf(newWord.charAt(0)).toUpperCase(Locale.ROOT)).append(newWord.substring(1)).append(' ');
            }
            newFilmNames.add(newFilmName.toString());
        }

        newFilmNames.forEach(System.out::println);
    }

}
