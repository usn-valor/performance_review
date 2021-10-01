package serializable;

import java.io.*;

/*
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной
*/

public class SingletonSerializable {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string"; /* статические поля класса и поля с модификатором
        transient по умолчанию не сериализуются */
        public int i;
        public int j;

        private void writeObject(ObjectOutputStream stream) throws IOException { /* метод для записи статического поля в
        файл, но тогда для сериализации обычных полей требуется вызов метода defaultWriteObject(). Всегда private */
            stream.defaultWriteObject();
            stream.writeObject(staticString);
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException { /* метод для чтения
        статического поля из файла, но тогда для десериализации обычных полей требуется вызов метода defaultReadObject()
        Всегда private */
            stream.defaultReadObject();
            staticString = (String) stream.readObject();
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            File objectFile = File.createTempFile("objectWithStaticField.bin",null);
            //System.out.println(objectFile.getPath()); // путь к созданному временному файлу
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile)); /* метод ClassWithStatic.writeObject
            обнаружен, поэтому oos передаётся в качестве параметра метода ClassWithStatic.writeObject() и выполняется уже
            его логика */
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile)); // аналогично oos

            ClassWithStatic first = new ClassWithStatic();
            first.staticString = "22222";
            oos.writeObject(first); /* происходит поиск метода ClassWithStatic.writeObject. В зависимости от успеха этого
            поиска, возможны два пути развития программы:
             - если обнаружен - выполнение обнаруженного метода;
             - не обнаружен - выполнение сериализации "по-умолчанию" */
            oos.close();

            first.staticString = "33333";

            ClassWithStatic second = (ClassWithStatic) ois.readObject();
            System.out.println(second.staticString);
            // у Вас будут разные надписи(в зависимости от наличия/отсутствия методов)
            ois.close();
        }
    }
}