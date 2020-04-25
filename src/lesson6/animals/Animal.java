package lesson6.animals;

public class Animal {
    String className;
    String name;
    String color;
    int age;
    double maxJumpHeight;
    int maxRunDistance;
    int maxSwimmingDistance;
    private static int animalCount = 0;

    private String[] jump = new String[]{"прыгать", "прыгнуть на высоту", "прыгнул на высоту", "прыжок"};
    private String[] run = new String[]{"бегать", "пробежать", "пробежал", "бег"};
    private String[] swim = new String[]{"плавать", "проплыть", "проплыл", "плавание"};
//    К сожалению не реализовал граммотный перевод для кличек животных женского рода, чтобы не слишком сильно увеличивать код домашнего задания.

    public Animal(String name, String color, int age, double maxJumpHeight, int maxRunDistance, int maxSwimmingDistance) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimmingDistance = maxSwimmingDistance;
        className = "Животное";
        animalCount += 1;
    }

    public void info() {
        System.out.printf("%s. Кличка: %s, Цвет: %s, Возраст: %d.%n", className, name, color, age);
        printActionInfo(jump, maxJumpHeight);
        printActionInfo(run, maxRunDistance);
        printActionInfo(swim, maxSwimmingDistance);
        System.out.printf("%n%n");
    }

    private void printActionInfo(String[] action, double maxValue) {
        if (maxValue == 0) {
            System.out.printf("Не умеет %s. ", action[0]);
        } else {
            System.out.printf("Может %s %.1fм. ", action[1], maxValue);
        }
    }

    public void jump(double height) {
        printActionResult(jump, height, maxJumpHeight);
    }

    public void run(int distance) {
        printActionResult(run, distance, maxRunDistance);
    }

    public void swim(int distance) {
        printActionResult(swim, distance, maxSwimmingDistance);
    }

    private void printActionResult(String[] action, double value, double maxValue) {
        System.out.println(action[3] + ": " + isDone(value, maxValue));

        if (isDone(value, maxValue)) {
            System.out.printf("%s %s %.1fм.%n", name, action[2], value);
        } else if (maxValue == 0) {
            System.out.printf("%s не умеет %s.%n", name, action[0]);
        } else {
            System.out.printf("%s не может %s %.1fм.%n", name, action[1], value);
        }
    }

    private boolean isDone(double value, double maxValue) {
        return value <= maxValue;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    @Override
    public String toString() {
        return ("Класс: " + className + "; Кличка: " + name + "; Цвет: " + color + "; Возраст: " + age + "; Высота прыжка: " + maxJumpHeight + "; Дистанция бег: " + maxRunDistance + "; Дистанция плавание: " + maxSwimmingDistance);
    }
}
