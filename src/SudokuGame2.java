/**
 * Created by gef on 4/5/2016.
 */


public class SudokuGame2 {

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
        for (int i=1; i<2; i++) {
            //putNumberRandomly(gameField, i);
            putNextNumber(gameField, i);
            printField(gameField);
        }
    }

    public static void putNextNumber(int[][] field, int number) {
        for (int sectorX=0; sectorX<3; sectorX++) {
            for (int sectorY=0; sectorY<3; sectorY++) {
                if (!isNumberPresentInSector(sectorX, sectorY, field, number))
                    findPlace(sectorX, sectorY, field, number);
            }
        }
    }

    /**
     * This method returns true if number present in sector
     * @param sectorX int
     * @param sectorY int
     * @param field   int[][]
     * @param number  int
     * @return boolean
     */
    public static boolean isNumberPresentInSector(int sectorX, int sectorY, int[][] field, int number) {
        for (int n=3*sectorX; n<=3*sectorX+2; n++) {
            for (int m=3*sectorY; m<=3*sectorY+2; m++) {
                if (field[n][m] == number)
                    return true;
            }
        }
        return false;
    }

    /**
     * This method finding coordinates to put number
     * @param sectorX int
     * @param sectorY int
     * @param field int[][]
     * @param number int
     */
    public static void findPlace(int sectorX, int sectorY, int[][] field, int number) {
        for (int line=3*sectorX; line<=3*sectorX+2; line++) {
            for (int lineElement=0; lineElement<9; lineElement++) {
                if ( (field[line][lineElement] == number) )
                    break;
                if ( (lineElement == 8) && (isThereFreePlaceForNumberInLine(sectorY, field, line)) ) {
                    for (int column=3*sectorY; column<=3*sectorY+2; column++) {
                        for (int columnElement=0; columnElement<9; columnElement++) {
                            if ( (field[columnElement][column] == number) )
                                break;
                            if ( (columnElement == 8) && (field[line][column] == 0) ) {
                                field[line][column] = number;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Method checks free place for number to place
     * @param sectorY   int
     * @param field     int[][]
     * @param checkLine int
     * @return boolean
     */
    public static boolean isThereFreePlaceForNumberInLine(int sectorY, int[][] field, int checkLine) {
        for (int i=3*sectorY; i<=3*sectorY+2; i++){
            if (field[checkLine][i] == 0)
                return true;
        }
        return false;
    }

    /**
     * Method is used to put number randomly in game field
     * @param field  int[][]
     * @param number int
     */
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
