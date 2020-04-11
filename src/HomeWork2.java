import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {

    static Random random = new Random();

    //    Задание 1.
    public static void array0To1Change() {
        int[] arrayQuestion1 = {0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1};
        System.out.println(Arrays.toString(arrayQuestion1));
        for (int i = 0; i < arrayQuestion1.length; i++) {
            if (arrayQuestion1[i] == 0) {
                arrayQuestion1[i] = 1;
            } else {
                arrayQuestion1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arrayQuestion1));
    }

    //Задание 2.
    public static void arrayPlus3Filling() {
        int[] arrayQuestion2 = new int[8];
        for (int i = 0; i < arrayQuestion2.length; i++) {
            arrayQuestion2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arrayQuestion2));
    }

    // Задание 3.
    public static void arrayLessThen6Double() {
        int[] arrayQuestion3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayQuestion3));
        for (int i = 0; i < arrayQuestion3.length; i++) {
            if (arrayQuestion3[i] < 6) {
                arrayQuestion3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrayQuestion3));
    }

    // Задание 4.
    public static void arrayDiagonalFilling() {
        int[][] arrayQuestion4 = new int[7][7];
        for (int i = 0; i < arrayQuestion4.length; i++) {
            arrayQuestion4[i][i] = 1;
            arrayQuestion4[i][(arrayQuestion4.length - 1) - i] = 1;
        }
        print2DIntArray(arrayQuestion4);
    }

    //    Задание 5.
    public static void minMaxArrElementFind() {
        int[] arrayQuestion5 = getIntArr(10, 1000);
        System.out.println(Arrays.toString(arrayQuestion5));
        Arrays.sort(arrayQuestion5);
        int minArrayElement = arrayQuestion5[0];
        int maxArrayElement = arrayQuestion5[arrayQuestion5.length - 1];
        int min3ArrayElement = arrayQuestion5[2];

        System.out.println(minArrayElement + " - минимальный элемент массива.");
        System.out.println(min3ArrayElement + " - минимальный третий элемент массива.");
        System.out.println(maxArrayElement + " - максимальный элемент массива.");
    }

    //    Задание 6.
    public static boolean checkBalance(int[] arr) {
        System.out.println(Arrays.toString(arr));
        boolean status = false;
        for (int i = 1; i < arr.length; i++) {
            if (sumArrLeftSide(arr, i) == sumArrRightSide(arr, i)) {
                System.out.println("Сумма первых " + i + " элементов слева равна сумме остальных элементов справа.");
                status = true;
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


    public static int sumArrRightSide(int[] arr, int n) {
        int sumArrRightSide = 0;
        for (int i = arr.length - 1; i >= n; i--) {
            sumArrRightSide += arr[i];
        }
        return sumArrRightSide;
    }

    public static int sumArrLeftSide(int[] arr, int n) {
        int sumArrLeftSide = 0;
        for (int i = 0; i < n; i++) {
            sumArrLeftSide += arr[i];
        }
        return sumArrLeftSide;
    }

    public static void scrollArrayRight(int[] arr, int scrollValue) {
        for (int j = 0; j < scrollValue; j++) {
            int HelpPartition = arr[arr.length - 1];
            System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0] = HelpPartition;
        }
    }

    public static void scrollArrayLeft(int[] arr, int scrollValue) {
        for (int j = 0; j > scrollValue; j--) {
            int HelpPartition = arr[0];
            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
            arr[arr.length - 1] = HelpPartition;
        }
    }

    public static void printScrollArray() {
        int[] arrQuestion7 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arrQuestion7));
        int scrollValue = 0;
        scrollArray(arrQuestion7, scrollValue);
        System.out.println(Arrays.toString(arrQuestion7));
    }

    public static int[] getIntArr(int arrayLength, int elementMaxValue) {
        int[] arr = new int[arrayLength];
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random()*(elementMaxValue*2 + 1) - elementMaxValue); // для создания рандомных чисел от отрицательного значения elementMaxValue до положительного.
            arr[i] = random.nextInt(elementMaxValue);
        }
        return arr;
    }

    public static void print2DIntArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Задание №1");
        array0To1Change();
        System.out.println();

        System.out.println("Задание №2");
        arrayPlus3Filling();
        System.out.println();

        System.out.println("Задание №3");
        arrayLessThen6Double();
        System.out.println();

        System.out.println("Задание №4");
        arrayDiagonalFilling();
        System.out.println();

        System.out.println("Задание №5");
        minMaxArrElementFind();
        System.out.println();

        System.out.println("Задание №6");
        System.out.println(checkBalance(getIntArr(8, 2)));
        System.out.println();

        System.out.println("Задание №7");
        printScrollArray();
        System.out.println();
    }
}