package oop;

public abstract class Animal {
    protected final String name;
    protected final int age;
    protected final String color;

    protected Animal(String name, String color, int age) {
        this.color = color;
        this.age = age;
        this.name = name;
    }

    public void move() {
        System.out.println(this.name + " walks on paws");
    }

    protected abstract void voice();
}
