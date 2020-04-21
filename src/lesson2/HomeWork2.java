package lesson2;

import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {

    static Random random = new Random();

    //    Задание 1.
    public static void array0To1Change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
//            arrayQuestion1[i] ^= 1; // ещё один вариант.
        }
    }

    //Задание 2.
    public static void arrayPlus3Filling(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    // Задание 3.
    public static void arrayLessThen6Double(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    // Задание 4.
    public static void arrayDiagonalFilling(int[][] arr2D, int value) {
        for (int i = 0; i < arr2D.length; i++) {
            arr2D[i][i] = value;
            arr2D[i][(arr2D.length - 1) - i] = value;
        }
    }

    public static void minMaxArrElementFind() {
        int[] arrayQuestion5 = getIntArr(10, 1000);
        System.out.println(Arrays.toString(arrayQuestion5));
        int minArrayElement = arrayQuestion5[0];
        int maxArrayElement = arrayQuestion5[0];
        for (int value : arrayQuestion5) {
            minArrayElement = Math.min(minArrayElement, value);
            maxArrayElement = Math.max(minArrayElement, value);
        }
        System.out.println(minArrayElement + " - минимальный элемент массива.");
        System.out.println(maxArrayElement + " - максимальный элемент массива.");
    }

    //    Задание 5. Альтернативный вариант с сортировкой.
//    public static void minMaxArrElementFindAlt() {
//        int[] arrayQuestion5 = getIntArr(10, 1000);
//        System.out.println(Arrays.toString(arrayQuestion5));
//        Arrays.sort(arrayQuestion5);
//        int minArrayElement = arrayQuestion5[0];
//        int maxArrayElement = arrayQuestion5[arrayQuestion5.length - 1];
//        int min3ArrayElement = arrayQuestion5[2];
//
//        System.out.println(minArrayElement + " - минимальный элемент массива.");
//        System.out.println(min3ArrayElement + " - минимальный третий элемент массива.");
//        System.out.println(maxArrayElement + " - максимальный элемент массива.");
//    }

    //    Задание 6. Метод проверяет есть ли баланс и если есть выводит все его точки.
    public static boolean checkBalance(int[] arr) {
        boolean status = false;
        int arraySum = 0;
        for (int i : arr) {
            arraySum += i;
        }
        if (arraySum % 2 != 0) {
            return false;
        }
        int sumLeft = 0;
        for (int i = 0; sumLeft <= arraySum / 2; i++) {
            sumLeft += arr[i];
            if (arraySum / 2 == sumLeft) {
                status = true;
                System.out.println("Сумма первых " + (i + 1) + " элементов слева равна сумме остальных элементов справа.");
            }
        }
        return status;
    }

    //    Задание 7.
    public static void scrollArray(int[] arr, int scrollValue) {
        if (scrollValue > 0) {
            scrollArrayRight(arr, scrollValue);
        } else {
            scrollArrayLeft(arr, scrollValue);
        }
    }

    public static void scrollArrayRight(int[] arr, int scrollValue) {
        scrollValue %= arr.length;
        for (int j = 0; j < scrollValue; j++) {
            int HelpPartition = arr[arr.length - 1];
            System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0] = HelpPartition;
        }
    }

    public static void scrollArrayLeft(int[] arr, int scrollValue) {
        scrollValue %= arr.length;
        for (int j = 0; j > scrollValue; j--) {
            int HelpPartition = arr[0];
            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
            arr[arr.length - 1] = HelpPartition;
        }
    }

    public static int[] getIntArr(int arrayLength, int elementMaxValue) {
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random()*(elementMaxValue*2 + 1) - elementMaxValue); // для создания рандомных чисел от отрицательного значения elementMaxValue до положительного.
            arr[i] = random.nextInt(elementMaxValue);
        }
        return arr;
    }

    public static void print2DArray(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Задание №1");
        int[] arrayQuestion1 = {0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1};
        System.out.println(Arrays.toString(arrayQuestion1));
        array0To1Change(arrayQuestion1);
        System.out.println(Arrays.toString(arrayQuestion1));
        System.out.println();

        System.out.println("Задание №2");
        int[] arrayQuestion2 = new int[8];
        arrayPlus3Filling(arrayQuestion2);
        System.out.println(Arrays.toString(arrayQuestion2));
        System.out.println();

        System.out.println("Задание №3");
        int[] arrayQuestion3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayQuestion3));
        arrayLessThen6Double(arrayQuestion3);
        System.out.println(Arrays.toString(arrayQuestion3));
        System.out.println();

        System.out.println("Задание №4");
        int[][] arrayQuestion4 = new int[7][7];
        arrayDiagonalFilling(arrayQuestion4, 1);
        print2DArray(arrayQuestion4);
        System.out.println();

        System.out.println("Задание №5");
        minMaxArrElementFind();
        System.out.println();

        System.out.println("Задание №6");
        int[] arrayQuestion6 = getIntArr(8, 2);
        System.out.println(Arrays.toString(arrayQuestion6));
        System.out.println(checkBalance(arrayQuestion6));
        System.out.println();

        System.out.println("Задание №7");
        int[] arrQuestion7 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arrQuestion7));
        int scrollValue = 1;
        scrollArray(arrQuestion7, scrollValue);
        System.out.println(Arrays.toString(arrQuestion7));
        System.out.println();
    }
}