package Advanced.ExamPreparation;

import java.util.Scanner;

public class L02FormulaOne {
    public static int pRow = 0;
    public static int pCol = 0;
    public static boolean hasFinished = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];


        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("P")) {
                pRow = i;
                pCol = line.indexOf("P");
            }
        }

        String[] commands = new String[numberOfCommands];
        for (int i = 0; i < numberOfCommands; i++) {
            commands[i] = scanner.nextLine();
            if (hasFinished) {
                break;
            }
        }
        for (String command : commands) {

            switch (command) {
                case "up":
                    moveCar(matrix, pRow - 1, pCol, command);
                    break;
                case "down":
                    moveCar(matrix, pRow + 1, pCol, command);
                    break;
                case "left":
                    moveCar(matrix, pRow, pCol - 1, command);
                    break;
                case "right":
                    moveCar(matrix, pRow, pCol + 1, command);
                    break;
                default:
                    break;
            }

        }
        if (hasFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static void moveCar(char[][] matrix, int newRow, int newCol, String command) {
        if (matrix[pRow][pCol] == 'P') {
            matrix[pRow][pCol] = '.';
        }
        if (isOutOfBounds(matrix, newRow, newCol)) {
            int[] newIndexes = flipCar(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }
        
        pRow = newRow;
        pCol = newCol;

        if (matrix[pRow][pCol] == 'B') {
            switch (command) {
                case "up":
                    newRow -= 1;
                    break;
                case "down":
                    newRow += 1;
                    break;
                case "left":
                    newCol -= 1;
                    break;
                case "right":
                    newCol += 1;
                    break;
                default:
                    break;

            }
        } else if (matrix[pRow][pCol] == 'T') {
            switch (command) {
                case "up":
                    newRow += 1;
                    break;
                case "down":
                    newRow -= 1;
                    break;
                case "left":
                    newCol += 1;
                    break;
                case "right":
                    newCol -= 1;
                    break;
                default:
                    break;

            }
        } else if (matrix[pRow][pCol] == 'F') {
            hasFinished = true;
        }
        if (isOutOfBounds(matrix, newRow, newCol)) {
            int[] newIndexes = flipCar(matrix.length, newRow, newCol);
            newRow = newIndexes[0];
            newCol = newIndexes[1];
        }
        pRow = newRow;
        pCol = newCol;
        matrix[pRow][pCol] = 'P';

    }

    private static int[] flipCar(int length, int r, int c) {
        int[] result = new int[2];
        if (r < 0) {
            result[0] = length - 1;
            result[1] = c;
        } else if (r >= length) {
            result[1] = c;
        } else if (c < 0) {
            result[0] = r;
            result[1] = length - 1;
        } else {
            result[0] = r;
        }
        return result;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}

