package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    {
        satiety = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate){
        if (plate.getFood() < appetite) {
            System.out.println("В тарелке осталось слишком мало еды. " + name + " не смог покушать.");
        } else {
            System.out.println(name + " покушал.");
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }

    public void printSatietyInfo () {
        if (satiety) {
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " остался голоден.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void voice () {
        System.out.println(name + " мяукает.");
    }
}
