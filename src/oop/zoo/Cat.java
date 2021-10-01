package oop.zoo;

import oop.Animal;

public class Cat extends Animal {

    public Cat(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public void voice() {
        System.out.println(this.name + " meows");
    }
}
