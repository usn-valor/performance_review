package class_relat;

public class Computer {

    private Mouse mouse;
    private CPU cpu;

    // композиция
    public Computer() {
        this.cpu = new CPU();
    }

    // агрегация
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
