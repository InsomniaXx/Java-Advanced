package Advanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L05MaximumSumSubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scanner, ", ");

        int[][] maxSubMatrix = getMaxSumSubMatrix(matrix);
        printMatrix(maxSubMatrix);
        System.out.println(getElementsSum(maxSubMatrix));
    }

    public static int[][] getMaxSumSubMatrix(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split(pattern);
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
        return matrix;
    }

    public static int[] readArray(String line, String regex) {
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int getElementsSum(int[][] matrix) {
        int sum = 0;

        for (int[] ints : matrix) {
            for (int col = 0; col < ints.length; col++) {
                sum += ints[col];
            }
        }

        return sum;
    }
}
