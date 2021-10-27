package Advanced.Exam;

import java.util.Scanner;

public class E02 {
    public static int pRow = 0;
    public static int pCol = 0;
    public static int countCheese = 0;
    public static boolean isOut = false;
    public static boolean hasEnded = false;
    public static String moveCommand = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("M")) {
                pRow = i;
                pCol = line.indexOf('M');
            }
        }

        while (!isOut) {
            String command = scanner.nextLine();
            moveCommand = command;

            if (command.equals("end")) {
                hasEnded = true;
                break;
            }
            matrix[pRow][pCol] = '-';

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
            }
            moveMouse(matrix, pRow, pCol);

        }
        if (isOut) {
            System.out.println("Where is the mouse?");
        }
        if (countCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", countCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - countCheese);
        }

        printMatrix(matrix, pRow, pCol);
    }

    private static void moveMouse(char[][] matrix, int row, int col) {
        if (matrix[row][col] == 'c') {
            matrix[row][col] = '-';
            countCheese++;
        } else if (matrix[row][col] == 'B') {
            matrix[row][col] = '-';
            if (moveCommand.equals("up")) {
                row--;
            } else if (moveCommand.equals("down")) {
                row++;
            } else if (moveCommand.equals("left")) {
                col--;
            } else if (moveCommand.equals("right")) {
                col++;
            }
        }

        if (isOutOfBounds(matrix, row, col)) {
            isOut = true;
        }
        if (matrix[row][col] == 'c') {
            matrix[row][col] = '-';
            countCheese++;
        }
        pRow = row;
        pCol = col;
        matrix[pRow][pCol] = 'M';

    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix.length;
    }

    private static void printMatrix(char[][] matrix, int r, int c) {
        for (char i = 0; i < matrix.length; i++) {
            for (char j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
