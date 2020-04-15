public class HomeWork1 {

    //    Задание 3.
    public static double calculation(double a, double b, double c, double d) {
        if (d == 0) {
            System.out.println("На ноль делить нельзя.");
            return 0;
        } else {
            return a * (b + (c / d));
        }
    }

    //    Задание 4.
    public static boolean task10and20(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    //    Задание 5.
    public static void digitIdentifier(int x) {
        if (isNegative(x)) {
            System.out.println(x + " - отрицательное число.");
        } else
            System.out.println(x + " - положительное число.");
    }

    //    Задание 6.
    public static boolean isNegative(int x) {
        return x < 0;
    }

    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYear(int year) {
        if (isLeapYear(year)) {
            System.out.println(year + " - високосный год.");
        } else {
            System.out.println(year + " - невисокосный год.");
        }
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4) != 0) {
            return false;
        } else if (year < 1582) {
            return false;
        } else return ((year % 100) != 0) || ((year % 400) == 0);
    }

    public static void main(String[] args) {
//        byte byteMaxValue = Byte.MAX_VALUE;
//        short shortMaxValue = Short.MAX_VALUE;
//        int intMinValue = Integer.MIN_VALUE;
//        long longMaxValue = 9_223_372_036_854_775_807L;
//        float piShort = 3.14f;
//        final double pi = Math.PI;
//        char piSymbol = '\u03C0';
//        boolean flag = true;

        System.out.println("Задание №3");
        double calcResult = calculation(2, 5, 6, 3);
        System.out.println(calcResult);

        System.out.println("Задание №4");
        System.out.println(task10and20(15, 5));

        System.out.println("Задание №5");
        int x = -273;
        digitIdentifier(x);

        System.out.println("Задание №6");
        System.out.println(isNegative(x));

        System.out.println("Задание №7");
        String name = "Фанзиль";
        sayHello(name);

        System.out.println("Задание №8");
        int year = 2020;
        leapYear(year);
    }
}