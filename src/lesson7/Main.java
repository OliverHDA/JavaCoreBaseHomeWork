package lesson7;

import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Plate plate = new Plate(80);
        String[] catNames = {"Барсик", "Снежок", "Пушок", "Васька", "Гарфилд", "Рыжик", "Тимофей"};
        Cat[] cats = new Cat[catNames.length];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(catNames[i], (random.nextInt(11) + 10));
        }

        for (Cat cat : cats) {
            plate.info();
            cat.eat(plate);
            cat.printSatietyInfo();
            if (!cat.isSatiety()) {
                cat.voice();
                plate.increaseFood(30);
                cat.eat(plate);
                cat.printSatietyInfo();
            }
            System.out.println();
        }
    }
}
