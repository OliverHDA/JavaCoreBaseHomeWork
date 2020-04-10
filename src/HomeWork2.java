import java.util.Arrays;

public class HomeWork2 {

    public static int[] array0To1Changer(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static int[] arrayCompletingQuestion2(int[] arr) {
        for(int i = 0, j = 0; i < arr.length; i++, j += 3) {
            arr[i] = j;
        }
        return arr;
    }

    public static int[] arrayLessThen6Double (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

//Задание 1.
        int[] arrayQuestion1 = {0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1};
        System.out.println(Arrays.toString(arrayQuestion1));
        System.out.println(Arrays.toString(array0To1Changer(arrayQuestion1)));

//Задание 2.
        int[] arrayQuestion2 = new int[8];
        System.out.println(Arrays.toString(arrayCompletingQuestion2(arrayQuestion2)));

//Задание 3.
        int[] arrayQuestion3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayQuestion3));
        System.out.println(Arrays.toString(arrayLessThen6Double(arrayQuestion3)));

//Задание 4.
//        int[][] arrayQuestion4 = new int[5][5];
//        for (int i = 0; i < arrayQuestion4.length; i++) {
//            arrayQuestion4 [i][i] = 1;
        }


    }
}
