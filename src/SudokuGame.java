/**
 * Created by gef on 4/4/2016.
 */


public class SudokuGame {

    public static void main(String[] args) {

        int[][] gameField = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        //putFirstNumbersRandomly(gameField);
        putNextNumber(gameField, 1);
        //printField(gameField);
    }

    public static void printField(int[][] gameField) {
        for (int[] row : gameField) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println("");
        }
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

    public static void findPlace(int sectorX, int sectorY, int[][] field, int number) {
        int placeX = 0; int placeY = 0;
        for (int n=3*sectorY; n<3*sectorY+2; n++) {
            for (int m=0; m<9; m++) {
                if ( (field[n][m] == number) ) {
                    break;
                }
                if (m == 8)
                    placeY = n; //номер строки в которой нет нужного нам числа
            }
        }
        System.out.println(placeY);
    }

    public static boolean isNumberPresentInSector(int i, int j, int[][] field, int number) {
        for (int n=3*i; n<=3*i+2; n++) {
            for (int m=3*j; m<=3*j+2; m++) {
                if (field[n][m] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void putFirstNumbersRandomly(int[][] field) {
        int numberToPaste = 1;
        for (int i=0; i<9; i++) {
            int coordinateX= getRandomPosition();
            int coordinateY = getRandomPosition();
            if (field[coordinateX][coordinateY] == 0){
                field[coordinateX][coordinateY] = numberToPaste;
                numberToPaste++;
            } else
                i--;
        }
    }

    public static int getRandomPosition() {
        return (int)(Math.random() * ((8) + 1));
    }
}
