package Advanced.ExamPreparation;

import java.util.Scanner;

public class E02Snake {
    public static int food = 10;
    public static boolean isFoodEaten = false;
    public static int pRow = 0;
    public static int pCol = 0;
    public static boolean isGameOver = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();

            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                pRow = i;
                pCol = line.indexOf("S");
            }
        }

        while (!isGameOver) {
            String command = scanner.nextLine();
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
                isGameOver = true;
                break;
            } else {
                moveSnake(matrix, pRow, pCol);
            }
            if (food == 0) {
                isFoodEaten = true;
                break;
            }
        }

        if (isFoodEaten) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + (10 - food));

        printMatrix(matrix, pRow, pCol);
    }

    private static void printMatrix(char[][] matrix, int pRow, int pCol) {
        for (char i = 0; i < matrix.length; i++) {
            for (char j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveSnake(char[][] matrix, int row, int col) {
        if (matrix[row][col] == '*') {
            food--;
            matrix[row][col] = '.';
        } else if (matrix[row][col] == 'B') {
            matrix[row][col] = '.';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'B') {
                        row = i;
                        col = j;
                    }
                }
            }
        }
        pRow = row;
        pCol = col;
        matrix[pRow][pCol] = 'S';
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix.length;
    }
}
