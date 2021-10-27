package Advanced.MultidimensionalArrays;


import java.util.Scanner;

public class E05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentRow = scanner.nextLine();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = currentRow.split(" ")[col];
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] nextCommand = command.split(" ");

            if (nextCommand.length != 5) {
                System.out.println("Invalid input!");
            } else {
                String swapCommand = nextCommand[0];
                int firstRow = Integer.parseInt(nextCommand[1]);
                int secondRow = Integer.parseInt(nextCommand[3]);

                int firstColumn = Integer.parseInt(nextCommand[2]);
                int secondColumn = Integer.parseInt(nextCommand[4]);

                if (!swapCommand.equals("swap") ||
                        (firstRow < 0 || firstRow >= rows || secondRow >= rows || secondRow < 0) ||
                        (firstColumn < 0 || firstColumn >= cols || secondColumn >= cols || secondColumn < 0)) {
                    System.out.println("Invalid input!");

                } else {

                    String oldValue = matrix[firstRow][firstColumn];
                    String newValue = matrix[secondRow][secondColumn];
                    matrix[firstRow][firstColumn] = newValue;
                    matrix[secondRow][secondColumn] = oldValue;

                    printMatrix(matrix, rows, cols);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println();
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
