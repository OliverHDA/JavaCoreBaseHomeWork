package lesson6.animals;

public class Cat extends Animal {

    private static int catCount = 0;

    public Cat(String name, String color, int age, double maxJumpHeight, int maxRunDistance) {
        super(name, color, age, maxJumpHeight, maxRunDistance, 0);
        className = "Кот";
        catCount +=1;
    }

    public Cat(String name, String color, int age) {
        this(name, color, age, 2, 200);
    }


    public static int getCatCount() {
        return catCount;
    }
}
