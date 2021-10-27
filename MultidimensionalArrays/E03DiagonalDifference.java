package Advanced.MultidimensionalArrays;

import java.util.Scanner;

public class E03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] currentValue = scanner.nextLine().split(" ");

            for (int col = 0; col < matrix.length; col++) {
                matrix[i][col] = Integer.parseInt(currentValue[col]);
            }
        }

        int difference = Math.abs(getPrimaryDiagonal(matrix) - getSecondaryDiagonal(matrix));

        System.out.println(difference);
    }

    private static int getSecondaryDiagonal(int[][] matrix) {
        int sumSecondaryDiagonal = 0;
        int startCol = matrix.length - 1;

        for (int row = 0; row < matrix.length; row++) {
            sumSecondaryDiagonal += matrix[row][startCol];

            startCol--;
        }
        return sumSecondaryDiagonal;
    }

    private static int getPrimaryDiagonal(int[][] matrix) {
        int primaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    primaryDiagonal += matrix[row][col];
                }
            }
        }

        return primaryDiagonal;
    }

    public static void printMatrix(int [][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
