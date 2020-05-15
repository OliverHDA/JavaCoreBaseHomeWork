package lesson8.XOGame;

import java.util.Arrays;
import java.util.Random;


public class Logic {

    static int SIZE;
    static int DOTS_TO_WIN;
    static final char DOT_EMPTY = '•';
    static final char DOT_O = 'O';
    static final char DOT_X = 'X';
    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static boolean isStep;

    static char[][] map;

    public static Random rand = new Random();

    static boolean isFinished = false;

    public static void play() {
        isFinished = true;
        if (isWin(DOT_X)) {
            return;
        }
        if (isMapFull()) {
            return;
        }
        if (isWin(DOT_O)) {
            return;
        }
        if (isMapFull()) {
            return;
        }
        isFinished = false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static boolean isSellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (isDotEmpty(map[y][x])) {
            return true;
        }
        return false;
    }

    public static void playerCoordinate(int x, int y, char symb) {
        isStep = false;
        if (isSellValid(x, y)) {
            isStep = true;
            map[y][x] = symb;
            play();
        }
    }

    public static void aiTurn() {
        int x;
        int y;
        int dotsInLine = DOTS_TO_WIN;
        boolean stepDone = false;
        while (dotsInLine > 2) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isWinPossible(DOT_O, i, j, dotsInLine)) {
                        map[i][j] = DOT_O;
                        stepDone = true;
                        break;
                    }
                    if (isWinPossible(DOT_X, i, j, dotsInLine)) {
                        map[i][j] = DOT_O;
                        stepDone = true;
                        break;
                    }
                }
                if (stepDone) {
                    break;
                }
            }
            dotsInLine--;
            if (stepDone) {
                break;
            }
        }
        if (!stepDone) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isSellValid(x, y));
            map[y][x] = DOT_O;
        }
        play();
    }

    public static boolean isWin(char symb) {
        char[] winLine = arrWinLine(symb, DOTS_TO_WIN);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isFreeSpaceForward(j) && checkLine(i, j, 0, 1, winLine)) {
                    x1 = j;
                    y1 = i;
                    x2 = j + DOTS_TO_WIN - 1;
                    y2 = i;
                    return true;
                }
                if (isFreeSpaceDown(i) && checkLine(i, j, 1, 0, winLine)) {
                    x1 = j;
                    y1 = i;
                    x2 = j;
                    y2 = i + DOTS_TO_WIN - 1;
                    return true;
                }
                if (isFreeSpaceDiagonal1(i, j) && checkLine(i, j, 1, 1, winLine)) {
                    x1 = j;
                    y1 = i;
                    x2 = j + DOTS_TO_WIN - 1;
                    y2 = i + DOTS_TO_WIN - 1;
                    return true;
                }
                if (isFreeSpaceDiagonal2(i, j) && checkLine(i, j, -1, 1, winLine)) {
                    x1 = j;
                    y1 = i;
                    x2 = j + DOTS_TO_WIN - 1;
                    y2 = i - DOTS_TO_WIN + 1;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDotEmpty(char coordinate) {
        return coordinate == DOT_EMPTY;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isDotEmpty(map[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isFreeSpaceForward(int j) {
        return (j + DOTS_TO_WIN <= SIZE);
    }

    private static boolean isFreeSpaceDown(int i) {
        return (i + DOTS_TO_WIN <= SIZE);
    }

    private static boolean isFreeSpaceDiagonal1(int i, int j) {
        return (isFreeSpaceForward(j) && isFreeSpaceDown(i));
    }

    private static boolean isFreeSpaceDiagonal2(int i, int j) {
        return (isFreeSpaceUp(i) && isFreeSpaceForward(j));
    }

    private static boolean isFreeSpaceUp(int i) {
        return i >= DOTS_TO_WIN - 1;
    }

    private static boolean isWinPossible(char symb, int i, int j, int dotsToWin) {
        if (dotsToWin < 2) {
            return false;
        }
        if (isDotEmpty(map[i][j])) {
            map[i][j] = 'V';
            if (isAIWin(symb, dotsToWin)) {
                map[i][j] = DOT_EMPTY;
                return true;
            }
            map[i][j] = DOT_EMPTY;
        }
        return false;
    }

    private static char[] arrWinLine(char symb, int dotsToWin) {
        char[] arr = new char[dotsToWin];
        for (int i = 0; i < dotsToWin; i++) {
            arr[i] = symb;
        }
        return arr;
    }

    private static boolean checkLine(int i, int j, int iVector, int jVector, char[] winLine) {
        char[] line = new char[DOTS_TO_WIN];
        for (int k = 0; k < DOTS_TO_WIN; k++) {
            line[k] = map[i + k * iVector][j + k * jVector];
        }
        return Arrays.equals(line, winLine);
    }

    private static boolean isAIWin(char symb, int dotsToWin) {
        char[] winLine = arrWinLine(symb, dotsToWin);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isFreeSpaceForward(j) && checkPossibleLine(i, j, 0, 1, winLine, symb, dotsToWin)) {
                    return true;
                }
                if (isFreeSpaceDown(i) && checkPossibleLine(i, j, 1, 0, winLine, symb, dotsToWin)) {
                    return true;
                }
                if (isFreeSpaceDiagonal1(i, j) && checkPossibleLine(i, j, 1, 1, winLine, symb, dotsToWin)) {
                    return true;
                }
                if (isFreeSpaceDiagonal2(i, j) && checkPossibleLine(i, j, -1, 1, winLine, symb, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkPossibleLine(int i, int j, int iVector, int jVector, char[] winLine, char symb, int dotsToWin) {
        boolean status = false;
        char[] line = new char[dotsToWin];
        for (int k = 0; k < dotsToWin; k++) {
            line[k] = map[i + k * iVector][j + k * jVector];
        }
        for (int k = 0; k < line.length; k++) {
            if (line[k] == 'V') {
                status = true;
                line[k] = symb;
                break;
            }
        }
        return status && Arrays.equals(line, winLine);
    }
}
