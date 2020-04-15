import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        gameSelect();
        scanner.close();
    }

    public static void gameSelect() {
        int incorrectInputCount = 0;
        while (true) {
            System.out.println("Выберите игру. Угадай число - '1', Угадай слово - '2', для выхода введите - 'q'");
            String userAnswer = scanner.next();
            if (userAnswer.equals("q")) {
                System.out.println("До свидания.");
                break;
            } else if (userAnswer.equals("1")) {
                guessNumberGame();
                incorrectInputCount = 0;
            } else if (userAnswer.equals("2")) {
                guessWordGame();
                incorrectInputCount = 0;
            } else {
                incorrectInputCount++;
                if (incorrectInputCount > 4) {
                    System.out.println("До свидания.");
                    break;
                }
                System.out.print("Некорректный ввод. ");
            }
        }
    }

    public static void guessNumberGame() {
        int difficultLevel = 100;
        int tryCount = 10;
        int answer = random.nextInt(difficultLevel);
        System.out.printf("Игра угадай число. Колличество попыток %d.%nУгадайте число от 0 до %d%n", tryCount, (difficultLevel - 1));
        guessNumber(answer, tryCount);
    }

    public static void guessNumber(int answer, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            try {
                String userAnswer = scanner.next();
                int userValue = Integer.parseInt(userAnswer);
                if (userValue == answer) {
                    System.out.println("Поздравляю, ответ верный.");
                    break;
                } else if (userValue < answer) {
                    System.out.println("Неверно. Загаданное число больше. Попыток осталось: " + (tryCount - 1 - i));
                } else {
                    System.out.println("Неверно. Загаданное число меньше. Попыток осталось: " + (tryCount - 1 - i));
                }
                if (i == (tryCount - 1)) {
                    System.out.println("Вы проиграли. Правильный ответ: " + answer);
                }
            } catch (NumberFormatException e) {
                System.out.println("Это не число. Попыток осталось: " + (tryCount - 1 - i));
            }
        }
    }

    public static void guessWordGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple"};
        String answer = words[random.nextInt(words.length)];
        System.out.println("Угадайте слово:");
        String userAnswer = scanner.nextLine();
        while (true) {
            userAnswer = scanner.nextLine();
            userAnswer = userAnswer.toLowerCase();
            if (answer.equals(userAnswer)) {
                System.out.println("Верно.");
                break;
            } else {
                System.out.println("Неверно.");
                System.out.println(helpString(answer, userAnswer));
            }
        }
    }

    public static StringBuilder helpString(String answer, String userAnswer) {
        StringBuilder str = new StringBuilder();
        int maxLength = Math.min(answer.length(), userAnswer.length());
        for (int i = 0; i < maxLength; i++) {
            char a = answer.charAt(i);
            char b = userAnswer.charAt(i);
            if (a == b) {
                str.append(b);
            } else {
                str.append("#");
            }
        }
        while (str.length() < 15) {
            str.append("#");
        }
        return str;
    }
}
