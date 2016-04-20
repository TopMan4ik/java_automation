/**
 * Created by gef on 4/13/2016.
 */


public class SudokuGenerator {

    public static void main(String[] args) {

        int[][] baseField = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};

        int[][] field = shuffleField(baseField);
        printField(field);
    }

    public static int[][] shuffleField(int[][] field) {
        for (int i=0; i<getRandomInt(10,12); i++) {
            swapRowsSector(field);
            swapColsSector(field);
            swapRowsArea(field);
            swapColsArea(field);
        }
        return field;
    }

    public static void swapRowsSector(int[][] field) {
        int randomRow = getRandomInt(0, 8);
        int randomRowToReplace = 0;
        int[] temp = new int[9];
        switch (randomRow) {
            case 0: randomRowToReplace = getRandomInt(0,2); break;
            case 1: randomRowToReplace = getRandomInt(0,2); break;
            case 2: randomRowToReplace = getRandomInt(0,2); break;
            case 3: randomRowToReplace = getRandomInt(3,5); break;
            case 4: randomRowToReplace = getRandomInt(3,5); break;
            case 5: randomRowToReplace = getRandomInt(3,5); break;
            case 6: randomRowToReplace = getRandomInt(6,8); break;
            case 7: randomRowToReplace = getRandomInt(6,8); break;
            case 8: randomRowToReplace = getRandomInt(6,8); break;
        }
        for (int i=0; i<9; i++) {
            temp[i] = field[randomRowToReplace][i];
            field[randomRowToReplace][i] = field[randomRow][i];
            field[randomRow][i] = temp[i];
        }
    }

    public static void swapColsSector(int[][] field) {
        int randomCol = getRandomInt(0, 8);
        int randomColToReplace = 0;
        int[] temp = new int[9];
        switch (randomCol) {
            case 0: randomColToReplace = getRandomInt(0,2); break;
            case 1: randomColToReplace = getRandomInt(0,2); break;
            case 2: randomColToReplace = getRandomInt(0,2); break;
            case 3: randomColToReplace = getRandomInt(3,5); break;
            case 4: randomColToReplace = getRandomInt(3,5); break;
            case 5: randomColToReplace = getRandomInt(3,5); break;
            case 6: randomColToReplace = getRandomInt(6,8); break;
            case 7: randomColToReplace = getRandomInt(6,8); break;
            case 8: randomColToReplace = getRandomInt(6,8); break;
        }
        for (int i=0; i<9; i++) {
            temp[i] = field[i][randomColToReplace];
            field[i][randomColToReplace] = field[i][randomCol];
            field[i][randomCol] = temp[i];
        }
    }

    public static void swapRowsArea(int[][] field) {
        int randomRowsArea = getRandomInt(0,2);
        int randomRowsAreaToReplace = getRandomInt(0,2);
        int[][] temp = new int[3][9];
        for (int i=0; i<3; i++) {
            for (int j=0; j<9; j++) {
                temp[i][j] = field[3*randomRowsAreaToReplace+i][j];
                field[3*randomRowsAreaToReplace+i][j] = field[3*randomRowsArea+i][j];
                field[3*randomRowsArea+i][j] = temp[i][j];
            }
        }
    }

    public static void swapColsArea(int[][] field) {

    }

    public static void printField(int[][] gameField) {
        System.out.println("Game field: ");
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(gameField[i][j] + " ");
                if (j == 2 | j == 5 | j == 8)
                    System.out.print("| ");
            }
            if (i == 2 | i == 5)
                System.out.println("\n_ _ _   _ _ _   _ _ _");
            System.out.println("");
        }
        System.out.println("");
    }

    public static int getRandomInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
