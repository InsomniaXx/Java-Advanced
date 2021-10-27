package Advanced.ExamPreparation;

import java.util.Scanner;

public class E02Bee {
    public static int pRow = 0;
    public static int pCol = 0;
    public static int countFlowers = 0; // 5

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isOut = false;

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("B")) {
                pRow = i;
                pCol = line.indexOf("B");
            }
        }

        while (!isOut) {
            String command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }
            matrix[pRow][pCol] = '.';
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

            if (isOutOfBounds(matrix, pRow, pCol)) {
                isOut = true;
                break;
            } else {
                moveBee(matrix, pRow, pCol, command);
            }
        }

        if (isOut) {
            System.out.println("The bee got lost!");
        }
        if (countFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", countFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - countFlowers);
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

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix.length;
    }

    private static void moveBee(char[][] matrix, int row, int col, String command) {
         if (matrix[row][col] == 'O') {
            matrix[row][col] = '.';
            switch (command) {
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
        }
        pRow = row;
        pCol = col;
        if (matrix[row][col] == 'f') {
            countFlowers++;
        }
        matrix[row][col] = 'B';
    }


}
