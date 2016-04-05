/**
 * Created by gef on 4/4/2016.
 */


public class SudokuGame {

    public static void main(String[] args) {

        int[][] gameField = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        putNumberRandomly(gameField, 1);
        putNextNumber(gameField, 1);
        putNumberRandomly(gameField, 2);
        putNextNumber(gameField, 2);
        printField(gameField);
    }



    public static void putNextNumber(int[][] field, int number) {
        for (int sectorX=0; sectorX<3; sectorX++) {
            for (int sectorY=0; sectorY<3; sectorY++) {
                if (!isNumberPresentInSector(sectorX, sectorY, field, number)) {
                    findPlace(sectorX, sectorY, field, number);
                }
            }
        }
    }

    /**
     * This method finding coordinates to put number
     * @param sectorX int
     * @param sectorY int
     * @param field int[][]
     * @param number int
     */
    public static void findPlace(int sectorX, int sectorY, int[][] field, int number) {
        int coordinateX = findCoordinateX(sectorX, sectorY, field, number);
        int coordinateY = findCoordinateY(coordinateX, sectorY, field, number);
        field[coordinateX][coordinateY] = number;
    }

    public static int findCoordinateX(int sectorX, int sectorY, int[][] field, int number) {
        int lineCheck = 9;
        for (int n=3*sectorX; n<=3*sectorX+2; n++) {
            for (int m=0; m<9; m++) {
                if ( (field[n][m] == number) )
                    break;
                if ( (m == 8) && (isThereFreePlaceForNumberInLine(sectorY, field, n)) )
                    lineCheck = n;
            }
        }
        return lineCheck;
    }

    public static boolean isThereFreePlaceForNumberInLine(int sectorY, int[][] field, int checkLine) {
        for (int i=3*sectorY; i<3*sectorY+2; i++){
            if (field[checkLine][i] == 0)
                return true;
        }
        return false;
    }

    public static int findCoordinateY(int coordinateX, int sectorY, int[][] field, int number) {
        for (int m=3*sectorY; m<=3*sectorY+2; m++) {
            for (int n=0; n<9; n++) {
                if ( (field[n][m] == number) )
                    break;
                if ( (n == 8) && (field[coordinateX][m] == 0) )
                    return m;
            }
        }
        return 9;
    }

    public static boolean isNumberPresentInSector(int sectorX, int sectorY, int[][] field, int number) {
        for (int n=3*sectorX; n<=3*sectorX+2; n++) {
            for (int m=3*sectorY; m<=3*sectorY+2; m++) {
                if (field[n][m] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void putNumberRandomly(int[][] field, int number) {
        while (true) {
            int coordinateX = (int)(Math.random() * ((8) + 1));
            int coordinateY = (int)(Math.random() * ((8) + 1));
            if (field[coordinateX][coordinateY] == 0) {
                field[coordinateX][coordinateY] = number;
                break;
            }
        }
    }

    /**
     * Prints game field
     * @param gameField int[][]
     */
    public static void printField(int[][] gameField) {
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
    }
}
