package lesson6.animals;

public class Dog extends Animal {

    private static int dogCount = 0;

    public Dog(String name, String color, int age, double maxJumpHeight, int maxRunDistance, int maxSwimmingDistance) {
        super(name, color, age, maxJumpHeight, maxRunDistance, maxSwimmingDistance);
        className = "Пёс";
        dogCount += 1;
    }

    public Dog(String name, String color, int age) {
        this(name, color, age, 0.5, 500, 10);
    }

    public static int getDogCount() {
        return dogCount;
    }
}
