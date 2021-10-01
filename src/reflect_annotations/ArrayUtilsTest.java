package reflect_annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayUtilsTest {

    private int[] arr = {1, 2, 5, 5, 2, 3, 4, 1, 7};

    @reflect_annotations.Test(1)
    @Test
    public void shouldDoWorkArray1() {
        Assertions.assertArrayEquals(new int[]{1, 7}, ArrayUtils.doWorkArray1(arr));
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenDoWorkArray1() {
        RuntimeException ex = Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ArrayUtils.doWorkArray1(arr);
            }
        });
        Assertions.assertEquals("SWW", ex.getMessage());
    }

    @ParameterizedTest
    @MethodSource("doWorkArray2ParametersProvider1")
    public void shouldDoSuccessfulParametrizeDoWorkArray1(int[] arr1, int[] arr2) {
        Assertions.assertArrayEquals(arr1, ArrayUtils.doWorkArray1(arr2));
    }

    private static Stream<Arguments> doWorkArray2ParametersProvider1() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 5, 5, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 8, 2, 3, 9, 1, 7}),
                Arguments.arguments(new int[]{2, 3, 5, 6, 7}, new int[]{9, 2, 5, 4, 2, 3, 5, 6, 7})
        );
    }

    @reflect_annotations.Test(5)
    @Test
    public void shouldDoWorkArray2() {
        Assertions.assertTrue(ArrayUtils.doWorkArray2(arr));
    }

    @ParameterizedTest
    @MethodSource("doWorkArray2ParametersProvider2")
    public void shouldDoSuccessfulParametrizeDoWorkArray2(int[] arr1) {
        Assertions.assertTrue(ArrayUtils.doWorkArray2(arr1));
    }

    private static Stream<Arguments> doWorkArray2ParametersProvider2() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 5, 5, 2, 3, 5, 1, 7}),
                Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(new int[]{9, 2, 5, 5, 2, 3, 5, 6, 7})
        );
    }
}
