package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static char[][] map;
    public static final int SIZE = 20;
    public static final int DOTS_TO_WIN = 5;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_O = 'O';
    public static final char DOT_X = 'X';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("Победил человек.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
            aiTurn();
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("Победил компьютер.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.printf("%-2d", i);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%-2d", (i + 1));
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isSellValid(x, y));
        map[y][x] = DOT_X;
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
                        System.out.println("Компьютер сделал ход " + (j + 1) + " " + (i + 1));
                        stepDone = true;
                        break;
                    }
                    if (isWinPossible(DOT_X, i, j, dotsInLine)) {
                        map[i][j] = DOT_O;
                        System.out.println("Компьютер сделал ход " + (j + 1) + " " + (i + 1));
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
            System.out.println("Компьютер сделал ход " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
    }

    public static boolean isWin(char symb) {
        char[] winLine = arrWinLine(symb, DOTS_TO_WIN);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isFreeSpaceForward(j) && checkLine(i, j, 0, 1, winLine)) {
                    return true;
                }
                if (isFreeSpaceDown(i) && checkLine(i, j, 1, 0, winLine)) {
                    return true;
                }
                if (isFreeSpaceDiagonal1(i, j) && checkLine(i, j, 1, 1, winLine)) {
                    return true;
                }
                if (isFreeSpaceDiagonal2(i, j) && checkLine(i, j, -1, 1, winLine)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDotEmpty(char coordinate) {
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

    public static boolean isFreeSpaceForward(int j) {
        return (j + DOTS_TO_WIN <= SIZE);
    }

    public static boolean isFreeSpaceDown(int i) {
        return (i + DOTS_TO_WIN <= SIZE);
    }

    public static boolean isFreeSpaceDiagonal1(int i, int j) {
        return (isFreeSpaceForward(j) && isFreeSpaceDown(i));
    }

    public static boolean isFreeSpaceDiagonal2(int i, int j) {
        return (isFreeSpaceUp(i) && isFreeSpaceForward(j));
    }

    public static boolean isFreeSpaceUp(int i) {
        return i >= DOTS_TO_WIN - 1;
    }

    public static boolean isWinPossible(char symb, int i, int j, int dotsToWin) {
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

    public static char[] arrWinLine(char symb, int dotsToWin) {
        char[] arr = new char[dotsToWin];
        for (int i = 0; i < dotsToWin; i++) {
            arr[i] = symb;
        }
        return arr;
    }

    public static boolean checkLine(int i, int j, int iVector, int jVector, char[] winLine) {
        char[] line = new char[DOTS_TO_WIN];
        for (int k = 0; k < DOTS_TO_WIN; k++) {
            line[k] = map[i + k * iVector][j + k * jVector];
        }
        return Arrays.equals(line, winLine);
    }

    public static boolean isAIWin(char symb, int dotsToWin) {
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

    public static boolean checkPossibleLine(int i, int j, int iVector, int jVector, char[] winLine, char symb, int dotsToWin) {
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