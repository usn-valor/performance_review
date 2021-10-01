package oop.zoo;

public final class Parrot extends Bird {

    public Parrot(String name, String color, int age, int flyHeight) {
        super(name, color, age, flyHeight);
    }

    public void speak() {
        System.out.println(this.name + " doorak");
    }

}
