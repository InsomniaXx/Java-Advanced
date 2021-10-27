package Advanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        int[][] matrix = new int[rows][cols];

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            fillMatrix(matrix, i, currentRow);
        }
        getMaxSum(matrix, rows, cols);

    }

    private static void getMaxSum(int[][] matrix, int rows, int cols) {
        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        int[][] maxMatrix = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum =
                        matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row][col + 2] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1] +
                        matrix[row + 1][col + 2] +
                        matrix[row + 2][col] +
                        matrix[row + 2][col + 1] +
                        matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                    fillMaxMatrix(matrix, maxMatrix, bestRow, bestCol);
                }

            }
        }
        System.out.println("Sum = " + maxSum);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(maxMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMaxMatrix(int[][] matrix, int[][] maxMatrix, int row, int col) {
        for (int i = 0; i < 3; i++) {
            int currentColumn = col;
            for (int j = 0; j < 3; j++) {
                maxMatrix[i][j] = matrix[row][currentColumn];
                currentColumn++;
            }
            row++;
        }
    }

    private static void fillMatrix(int[][] matrix, int row, int[] currentRow) {
        for (int col = 0; col < currentRow.length; col++) {
            matrix[row][col] = currentRow[col];
        }
    }
}
