package reflect_annotations;

import java.util.Arrays;

public class ArrayUtils {

    public static void main(String[] args) {

        int[] beforeArray = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        System.out.println(Arrays.toString(beforeArray));

        int[] afterArray = doWorkArray1(beforeArray);
        System.out.println(Arrays.toString(afterArray));

        System.out.println(doWorkArray2(beforeArray));
    }

    public static int[] doWorkArray1(int[] arr) {
        int value = 0;
        boolean bool = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                bool = true;
                break;
            }
        }
        if (!bool)
            throw new RuntimeException("SWW");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4)
                value = i;
        }
        int[] newArr = new int[arr.length - (value + 1)];
        System.arraycopy(arr, value + 1, newArr, 0, newArr.length);

        return newArr;
    }

    public static boolean doWorkArray2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4 || arr[i] == 1)
                return true;
        }
        return false;
    }
}
