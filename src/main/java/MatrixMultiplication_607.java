import java.util.Scanner;

public class MatrixMultiplication_607 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String matIndexes = scanner.nextLine();
        String[] matIndexesSplit = matIndexes.split(" ");
        int i, j, k;
        i = Integer.parseInt(matIndexesSplit[0]);
        j = Integer.parseInt(matIndexesSplit[1]);
        k = Integer.parseInt(matIndexesSplit[2]);
        int[][] matA;
        int[][] matB;

        matA = readMatrix(i, j, scanner);
        matB = readMatrix(j, k, scanner);

        printMatrix(matrixMultiplier(matA, matB));
    }

    private static int[][] matrixMultiplier(int[][] matA, int[][] matB) {
        int a, b;
        a = matA.length;
        b = matB[0].length;
        int[][] matrix = new int[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = 0;
                for (int k = 0; k < matB.length; k++) {
                    matrix[i][j] += matA[i][k] * matB[k][j];
                    matrix[i][j] = matrix[i][j];
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j]);
                if (j != ints.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int i, int j, Scanner scanner) {
        int[][] matrix = new int[i][j];
        for (int a = 0; a < i; a++) {
            String elementsLine = scanner.nextLine();
            String[] elements = elementsLine.split(" ");
            for (int b = 0; b < j; b++) {
                matrix[a][b] = Integer.parseInt(elements[b]);
            }
        }
        return matrix;
    }
}
