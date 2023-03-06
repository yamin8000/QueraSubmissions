import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Election_604 {
    public static void main(String... args) {
        var scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(winner(n));
    }

    private static int winner(int total) {
        List<Integer> list = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            list.add(i + 1);
        }
        return winner(1, list);
    }

    private static int winner(int start, List<Integer> list) {
        if (list.size() == 1) return list.get(0);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1) % 2 == start)
                temp.add(list.get(i));
        }
        if (start == 1 && list.size() % 2 == 0) return winner(1, temp);
        if (start == 1) return winner(0, temp);
        if (start == 0 && list.size() % 2 == 0) return winner(0, temp);
        if (start == 0) return winner(1, temp);
        return -1;
    }
}
