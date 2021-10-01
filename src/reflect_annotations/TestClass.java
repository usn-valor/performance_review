package reflect_annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ArrayUtilsTest utilsTest = new ArrayUtilsTest();
        start(utilsTest.getClass());
    }

    private static void start(Class<?> clazz) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int beforeCount = 0, afterCount = 0;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Constructor<?> cons = clazz.getDeclaredConstructor();

        for (Method method: declaredMethods) {
            if (method.getDeclaredAnnotation(BeforeSuite.class) != null && beforeCount == 0) {
                method.invoke(cons.newInstance());
                beforeCount++;
            }
            else if (method.getDeclaredAnnotation(BeforeSuite.class) != null && beforeCount > 0)
                throw new RuntimeException("SWW");
        }

        for (int i = 1; i <= 10; i++) {
            for (Method method: declaredMethods) {
                Test annotation = method.getDeclaredAnnotation(Test.class);
                if (annotation != null && annotation.value() == i)
                    method.invoke(cons.newInstance());
            }
        }

        for (Method method: declaredMethods) {
            if (method.getDeclaredAnnotation(AfterSuite.class) != null && afterCount == 0) {
                method.invoke(cons.newInstance());
                afterCount++;
            }
            else if (method.getDeclaredAnnotation(AfterSuite.class) != null && afterCount > 0)
                throw new RuntimeException("SWW");
        }
    }
}
