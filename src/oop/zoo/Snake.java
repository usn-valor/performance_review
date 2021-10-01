package oop.zoo;

import oop.Animal;

public class Snake extends Animal {
    public Snake(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public void move() {
        System.out.println(this.name + " crawls");
    }

    @Override
    public void voice() {
        System.out.println("Listen to me, banderlogs!");
    }
}
