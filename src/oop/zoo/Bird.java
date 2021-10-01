package oop.zoo;

import oop.Animal;

public class Bird extends Animal {

    int flyHeight;

    public Bird(String name, String color, int age, int flyHeight) {
        super(name, color, age);
        this.flyHeight = flyHeight;
    }

    @Override
    public void voice() {
        System.out.println(this.name + " tweets");
    }

    public final void fly() {
        System.out.println(this.name + " flies on height: " + flyHeight);
    }

}
