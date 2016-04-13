/**
 * Created by gef on 4/5/2016.
 */


public class SudokuFieldCreatorV3 {

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

        putFirstNumbersRandomly(gameField);
        for (int i=1; i<10; i++)
            putNextNumber(gameField, i);
        printField(gameField);
    }

    public static void putNextNumber(int[][] field, int number) {
        for (int sectorX=0; sectorX<3; sectorX++) {
            for (int sectorY=0; sectorY<3; sectorY++) {
                if (!isNumberPresentInSector(sectorX, sectorY, field, number)) {
                    int[] coordinates = findPlace(sectorX, sectorY, field, number);
                    field[coordinates[0]][coordinates[1]] = number;
                }
            }
        }
    }

    public static boolean isNumberPresentInSector(int sectorX, int sectorY, int[][] field, int number) {
        for (int n=3*sectorX; n<=3*sectorX+2; n++) {
            for (int m=3*sectorY; m<=3*sectorY+2; m++) {
                if (field[n][m] == number)
                    return true;
            }
        }
        return false;
    }

    public static int[] findPlace(int sectorX, int sectorY, int[][] field, int number) {
        int[] coordinates = new int[2];
        for (int cellX=3*sectorX; cellX<=3*sectorX+2; cellX++) {
            for (int cellY=3*sectorY; cellY<=3*sectorY+2; cellY++) {
                if ( field[cellX][cellY] == 0 && !isLineContainNumber(cellX, field, number) && !isColumnContainNumber(cellY, field, number)) {
                    coordinates[0] = cellX; coordinates[1] = cellY;
                }
            }
        }
        return coordinates;
    }

    public static boolean isLineContainNumber(int line, int[][] field, int number) {
        for (int i=0; i<9; i++) {
            if (field[line][i] == number)
                return true;
            if (i == 8)
                return false;
        }
        return false;
    }

    public static boolean isColumnContainNumber(int column, int[][] field, int number){
        for (int i=0; i<9; i++) {
            if (field[i][column] == number)
                return true;
            if (i == 8)
                return false;
        }
        return false;
    }

    public static void putFirstNumbersRandomly(int[][] field) {
        for (int number=1; number<=9; number++) {
            while (true) {
                int coordinateX = (int) (Math.random() * ((8) + 1));
                int coordinateY = (int) (Math.random() * ((8) + 1));
                if (field[coordinateX][coordinateY] == 0) {
                    field[coordinateX][coordinateY] = number;
                    break;
                }
            }
        }
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

}
