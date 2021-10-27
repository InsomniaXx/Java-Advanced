package Advanced.ExamPreparation;

import java.util.Scanner;

public class E02Selling {
    public static int row = 0;
    public static int col = 0;
    public static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isOut = false;
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("S")) {
                row = i;
                col = line.indexOf('S');
            }
        }
        while (!isOut) {
            String command = scanner.nextLine();

            if (matrix[row][col] == 'S') {
                matrix[row][col] = '-';
            }
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
                    continue;
            }
            if (isOutOfBounds(matrix, row, col)) {
                isOut = true;
                break;
            } else {
                sellingMove(matrix, row, col);
            }
            if (money >= 50) {
                isOut = true;
            }
        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.println("Money: " + money);
        } else {
            System.out.println("Bad news, you are out of the Advanced.Classes.bakery.");
            System.out.println("Money: " + money);
        }
        printMatrix(matrix);
    }


    private static void sellingMove(char[][] matrix, int nRow, int nCol) {
        if (Character.isDigit(matrix[nRow][nCol])) {
            money += matrix[nRow][nCol] - '0';
            matrix[nRow][nCol] = '-';
            matrix[row][col] = 'S';
        } else if (matrix[nRow][nCol] == 'O') {
            matrix[nRow][nCol] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'O') {
                        nRow = i;
                        nCol = j;
                    }
                }
            }
        }
        row = nRow;
        col = nCol;
        matrix[row][col] = 'S';

    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 ||
                row >= matrix.length ||
                col < 0 ||
                col >= matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element: arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
