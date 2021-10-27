package Advanced.ExamPreparation;

import java.util.Scanner;

public class E02ReVolt {
    public static int pRow = 0;
    public static int pCol = 0;
    public static boolean reachedFinishMark = false;
    public static String movementCommand = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowSize = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowSize][rowSize];

        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine();

            matrix[i] = line.toCharArray();

            if (line.contains("f")) {
                pRow = i;
                pCol = line.indexOf("f");
            }
        }


        for (int i = 0; i < countCommands; i++) {
            String command = scanner.nextLine();
            movementCommand = command;
            if (matrix[pRow][pCol] == 'f') {
                matrix[pRow][pCol] = '-';
            }
            switch (command) {
                case "up":
                    pRow--;
                    break;
                case "down":
                    pRow++;
                    break;
                case "left":
                    pCol--;
                    break;
                case "right":
                    pCol++;
                    break;
                default:
                    break;
            }
            movePlayer(matrix, pRow, pCol);

            if (reachedFinishMark) {
                break;
            }
        }

        if (reachedFinishMark) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix, pRow, pCol);
    }


    private static void printMatrix(char[][] matrix, int pRow, int pCol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void movePlayer(char[][] matrix, int row, int col) {
        if (isOutOfBounds(matrix, row, col)) {
            int[] newIndexes = flip(matrix, row, col);
            row = newIndexes[0];
            col = newIndexes[1];
        }
        char currentChar = matrix[row][col];
        if (matrix[row][col] == 'B' || matrix[row][col] == 'T') {
            int[] newIndexes = additionalMovement(matrix, row, col, currentChar);
            row = newIndexes[0];
            col = newIndexes[1];
        }
        if (isOutOfBounds(matrix, row, col)) {
            int[] newIndexes = flip(matrix, row, col);
            row = newIndexes[0];
            col = newIndexes[1];
        }
        if (matrix[row][col] == 'F') {
            reachedFinishMark = true;
        }
        pRow = row;
        pCol = col;
        matrix[pRow][pCol] = 'f';
    }

    private static int[] additionalMovement(char[][] matrix, int row, int col, char currentChar) {
        int[] newIndexes = new int[2];

        if (currentChar == 'B') {
            switch (movementCommand) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
                default:
                    break;
            }
        } else if (currentChar == 'T') {
            switch (movementCommand) {
                case "up":
                    row++;
                    break;
                case "down":
                    row--;
                    break;
                case "left":
                    col++;
                    break;
                case "right":
                    col--;
                    break;
                default:
                    break;
            }
        }
        newIndexes[0] = row;
        newIndexes[1] = col;
        return newIndexes;
    }

    private static int[] flip(char[][] matrix, int row, int col) {
        int[] result = new int[2];

        if (row < 0) {
            result[0] = matrix.length - 1;
            result[1] = col;
        } else if (row >= matrix.length) {
            result[1] = col;
        } else if (col < 0) {
            result[0] = row;
            result[1] = matrix.length - 1;
        } else if (col >= matrix.length) {
            result[0] = row;
        }
        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }
}
