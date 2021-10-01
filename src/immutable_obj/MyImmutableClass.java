package immutable_obj;

public final class MyImmutableClass {

    private final int a;
    private final int b;

    public MyImmutableClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getSum() {
        return a + b;
    }
}
