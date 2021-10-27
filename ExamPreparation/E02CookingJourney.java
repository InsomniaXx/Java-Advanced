package Advanced.ExamPreparation;

import java.util.Scanner;

public class E02CookingJourney {
    public static int money = 0;
    public static int pRow = 0;
    public static int pCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean outOfPastry = false;
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
        while (money < 50) {
            String nextCommand = scanner.nextLine();

            if (matrix[pRow][pCol] == 'S') {
                matrix[pRow][pCol] = '-';
            }
            if (nextCommand.equals("up")) {
                pRow--;
            } else if (nextCommand.equals("down")) {
                pRow++;
            } else if (nextCommand.equals("left")) {
                pCol--;
            } else if (nextCommand.equals("right")) {
                pCol++;
            } else {
                continue;
            }
            if (isOutOfBounds(matrix, pRow, pCol)) {
                break;
            } else {
                cookeryMove(matrix, pRow, pCol);
            }
        }
        if (money < 50) {
            System.out.println("Bad news! You are out of the pastry shop.");
            System.out.println("Money: " + money);
            printMatrix(matrix);
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.println("Money: " + money);
            printMatrix(matrix);
        }
    }

    private static void cookeryMove(char[][] matrix, int newRow, int newCol) {
        if (Character.isDigit(matrix[newRow][newCol])) {
            money += matrix[newRow][newCol] - '0';
            matrix[newRow][newCol] = '-';
        } else if (matrix[newRow][newCol] == 'P') {
            matrix[newRow][newCol] = '-';
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'P') {
                        newRow = i;
                        newCol = j;
                    }
                }
            }
        }
        pRow = newRow;
        pCol = newCol;
        matrix[newRow][newCol] = 'S';
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix[r].length || c < 0 || c >= matrix[r].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + "");
            }
            System.out.println();
        }
    }
}
