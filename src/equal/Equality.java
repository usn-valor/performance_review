package equal;

import java.util.Arrays;

public class Equality {

    public static void main(String[] args) {
        valCompare();
    }

    public static void valCompare() {
        int a = 4;
        int b = 8;
        String string1 = "equals";
        String string2 = "equals";

        String string3 = new String("equals");

        System.out.println(a == b);
        System.out.println(string1.equals(string2));
        System.out.println(string1.equals(string3));
    }

    public static void intCache() {
        Integer integer1 = 3; // в диапазоне от -128 до 127 при автоупаковке включается cached pool
        Integer integer2 = 3;

        Integer integer3 = 129;
        Integer integer4 = 129;

        if (integer1 == integer2)
            System.out.println("integer1 == integer2");
        else
            System.out.println("integer1 != integer2");

        if (integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");
    }
}
