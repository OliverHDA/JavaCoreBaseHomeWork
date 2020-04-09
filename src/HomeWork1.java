public class HomeWork1 {

    public static float calculation(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean task10and20(int x1, int x2) {
        return (((x1 + x2) >= 10) && ((x1 + x2) <= 20));
    }

    public static boolean negativeNumber(int x) {
        return x < 0;
    }

    public static String positiveNegativeIdentifier(int x) {
        return ((negativeNumber(x))) ? " - отрицательное число." : " - положительное число.";
    }

    public static void positiveNegativeNumber(int x) {
        System.out.println(x + positiveNegativeIdentifier(x));
    }

    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static String leapYear(int year) {
        return (leapYearFinder(year)) ? " - високосный год." : " - невисокосный год.";
    }

    public static void leapYearOut(int year) {
        System.out.println(year + leapYear(year));
    }

    public static boolean leapYearFinder(int year) {
        if ((year % 4) != 0) {
            return false;
        } else if (year < 1582) {
            return false;
        } else if (((year % 100) == 0) && ((year % 400) != 0)) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        byte byteMaxValue = 127;
        short shortMaxValue = 32767;
        int intMaxValue = 2147483647;
        long longMaxValue = 9223372036854775807L;
        float piShort = 3.14f;
        final double pi = Math.PI;
        char piSymbol = '\u03C0';
        boolean piIsPositive = true;

        String name = "Фанзиль";
        sayHello(name);

        float a = 2.0f;
        float b = 3.0f;
        float c = 10.0f;
        float d = 5.0f;
        System.out.println(calculation(a, b, c, d));

        int x1 = 15;
        int x2 = 5;
        System.out.println(task10and20(x1, x2));

        int x = -273;
        System.out.println(negativeNumber(x));
        positiveNegativeNumber(x);

        int year = 2020;
        leapYearOut(year);
    }
}