package Advanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L04MatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getElementsSum(matrix));
    }

    private static int getElementsSumByStream(int[][] matrix) {
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sum();
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

    public static int[] readArray(String line, String regex) {
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
