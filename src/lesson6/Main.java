package lesson6;

import lesson6.animals.Animal;
import lesson6.animals.Cat;
import lesson6.animals.Dog;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", "черный", 2);
        Cat cat2 = new Cat("Мурзик", "рыжий", 1, 2.5, 300);
        Cat cat3 = new Cat("Пушок", "белый", 4, 1.5, 100);

        Dog dog1 = new Dog("Тузик", "черно-белый", 6);
        Dog dog2 = new Dog("Шарик", "черный", 3, 1, 1000, 20);

        cat1.jump(2.5);
        cat1.info();

        cat2.run(200);
        cat2.info();

        cat3.swim(5);
        cat3.info();

        dog1.jump(2);
        dog1.run(500);
        dog1.info();

        dog2.swim(15);
        dog2.info();

        System.out.println();
        System.out.printf("Всего животных: %dшт.%nКошек: %dшт.%nСобак: %dшт.%n", Animal.getAnimalCount(), Cat.getCatCount(), Dog.getDogCount());
    }
}
