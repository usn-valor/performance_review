package generics;

import java.util.List;

public class MyGeneric<E extends List<MyGeneric.SomeClass>> {

    public static class SomeClass<T extends Number> {
    }

    public static void main(String[] args) {

    }
}
