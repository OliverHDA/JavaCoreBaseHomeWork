import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        guessNumberGame();
        playAgain();
        guessWordGame();
        scanner.close();
    }

    public static void guessNumberGame() {
        int answer = random.nextInt(10);
        System.out.println("Игра угадай число. У вас 3 попытки.");
        guessNumber(answer);
    }

    private static void guessNumber(int answer) {
        System.out.println("Угадайте число от 0 до 9");
        for (int i = 0; i < 3; i++) {
            int UserInt = scanner.nextInt();
            if (UserInt == answer) {
                System.out.println("Поздравляю, ответ верный.");
                break;
            } else if (UserInt < answer) {
                System.out.println("Неверно. Загаданное число больше.");
            } else {
                System.out.println("Неверно. Загаданное число меньше.");
            }
            if (i == 2) {
                System.out.println("Вы проиграли.");
            }
        }
    }

    public static void playAgain() {
        int userAnswer;
        do {
            System.out.println("Хотите сыграть ещё раз? Да - 1, нет - 0:");
            userAnswer = scanner.nextInt();
            switch (userAnswer) {
                case 0:
                    System.out.println("До свидания.");
                    break;
                case 1:
                    guessNumberGame();
                    break;
                default:
                    System.out.println("Некорректный ввод. Если хотите сыграть ещё раз введите - 1, если хотите выйти введите - 0");
                    break;
            }
        } while (userAnswer != 0);
    }

    public static void guessWordGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple"};
        String answer = words[random.nextInt(words.length)];
        System.out.println("Угадайте слово:");
        String userAnswer;
        do {
            userAnswer = scanner.nextLine();
            userAnswer = userAnswer.toLowerCase();
            if (answer.equals(userAnswer)) {
                System.out.println("Верно.");
            } else {
                System.out.println("Неверно.");
                System.out.println(helpString(answer, userAnswer));
            }
        } while (!answer.equals(userAnswer));
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
