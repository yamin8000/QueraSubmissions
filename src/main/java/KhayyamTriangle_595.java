import java.util.ArrayList;
import java.util.Scanner;

public class KhayyamTriangle_595 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<ArrayList<Integer>> binomials = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> subBinomial = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) subBinomial.add(0);
            binomials.add(subBinomial);
            binomials.get(i).set(0, 1);
            if (binomials.get(i).size() > 1)
                binomials.get(i).set(binomials.get(i).size() - 1, 1);
        }
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                ArrayList<Integer> subBinomial = binomials.get(i);
                int subBinomialSize = subBinomial.size();
                for (int j = 1; j < subBinomialSize - 1; j++) {
                    ArrayList<Integer> lastSubBinomial = binomials.get(i - 1);
                    int temp = lastSubBinomial.get(j) + lastSubBinomial.get(j - 1);
                    subBinomial.set(j, temp);
                }
            }
        }
        for (ArrayList<Integer> binomial : binomials) {
            int binomialSize = binomial.size();
            for (int i = 0; i < binomialSize; i++) {
                System.out.print(binomial.get(i));
                if (i != binomialSize - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
