package oop;

import oop.zoo.*;

public class Main {

    public static void main(String[] args) {
        Cat c = new Cat("Barseek", "White", 5);
        Dog d = new Dog("Toozeek", "Black", 7);
        Bird b = new Bird("Cheejeek", "Yellow", 2, 10);
        Parrot p = new Parrot("Popka", "Rainbow", 1, 5);
        Snake s = new Snake("Kaa", "Brown", 15);

        Animal[] zoo = {c, d, b, p, s};
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].move();
            zoo[i].voice();
            if (zoo[i] instanceof Bird) {
                System.out.println("enlarge a cage for " + zoo[i].name);
                Bird bird = (Bird) zoo[i];
                bird.fly();
            }
            if (zoo[i] instanceof Parrot) {
                ((Parrot) zoo[i]).speak();
            }
        }

        doAnimal(d);
    }

    private static void doAnimal(Animal animal) {
        animal.voice();
    }
}
