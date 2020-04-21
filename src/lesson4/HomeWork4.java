package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
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
        boolean stepDone = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isWinPossible(DOT_O, i, j)) {
                    map[i][j] = DOT_O;
                    System.out.println("Компьютер сходил " + (j + 1) + " " + (i + 1));
                    stepDone = true;
                    break;
                } else if (isWinPossible(DOT_X, i, j)) {
                    map[i][j] = DOT_O;
                    System.out.println("Компьютер сходил " + (j + 1) + " " + (i + 1));
                    stepDone = true;
                    break;
                }
            }
            if (stepDone) {
                break;
            }
        }
        if (!stepDone) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isSellValid(x, y));
            System.out.println("Компьютер сходил " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
    }

    public static boolean isSellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return isDotEmpty(map[y][x]);
    }

    public static boolean isWin(char symb) {
        char[] winLine = arrWinLine(symb);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                char[] line = new char[DOTS_TO_WIN];
                if (isFreeSpaceForward(j)) {
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        line[k] = map[i][j + k];
                    }
                    if (Arrays.equals(line, winLine)) {
                        return true;
                    }
                }
                if (isFreeSpaceDown(i)) {
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        line[k] = map[i + k][j];
                    }
                    if (Arrays.equals(line, winLine)) {
                        return true;
                    }
                }
                if (isFreeSpaceDiagonal1(i, j)) {
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        line[k] = map[i + k][j + k];
                    }
                    if (Arrays.equals(line, winLine)) {
                        return true;
                    }
                }
                if (isFreeSpaceDiagonal2(i, j)) {
                    for (int k = 0; k < DOTS_TO_WIN; k++) {
                        line[k] = map[i - k][j + k];
                    }
                    if (Arrays.equals(line, winLine)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static char[] arrWinLine(char symb) {
        char[] arr = new char[DOTS_TO_WIN];
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            arr[i] = symb;
        }
        return arr;
    }

    public static boolean isWinPossible(char symb, int i, int j) {
        if (isDotEmpty(map[i][j])) {
            map[i][j] = symb;
            if (isWin(symb)) {
                map[i][j] = DOT_EMPTY;
                return true;
            }
            map[i][j] = DOT_EMPTY;
        }
        return false;
    }

    public static boolean isDotEmpty(char coordinate) {
        return coordinate == DOT_EMPTY;
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

    private static boolean isFreeSpaceUp(int i) {
        return i >= DOTS_TO_WIN - 1;
    }
}