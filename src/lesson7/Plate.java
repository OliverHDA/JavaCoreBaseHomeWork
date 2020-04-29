package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("В тарелке " + food + " единиц еды.");
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        food -= amount;

    }
    public void increaseFood (int amount) {
        System.out.println("Хозяин положил в тарелку ещё еды."); //Можно создать класс Owner, чтобы он клал еду.
        food += amount;
    }
}
