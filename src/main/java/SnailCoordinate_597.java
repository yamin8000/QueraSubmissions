import java.util.Scanner;

public class SnailCoordinate_597 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        n += 5;

        int[][] snailMap = new int[n][2];
        for (int i = 0; i < n; i++) {
            snailMap[i] = new int[]{0, 0};
        }
        //north-east
        way(3, n - 3, 1, 1, snailMap);
        //north-west
        way(4, n - 2, -1, 1, snailMap);
        //south-west
        way(5, n - 1, -1, -1, snailMap);
        //south-east
        way(2, n, 1, -1, snailMap);

        System.out.println(snailMap[n - 5][0] + " " + snailMap[n - 5][1]);
    }

    private static void way(int start, int end, int x, int y, int[][] snailMap) {
        for (int i = start; i < end; i += 4) {
            if (i == 2) {
                snailMap[i] = new int[]{x, 0};
            } else if (i == 3 || i == 4 || i == 5) {
                snailMap[i] = new int[]{x, y};
            } else {
                int oldX = snailMap[i - 4][0];
                int oldY = snailMap[i - 4][1];
                snailMap[i] = new int[]{oldX + x, oldY + y};
            }
        }
    }
}
