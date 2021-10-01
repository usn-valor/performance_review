package multithreading;

public class Uncaught {

    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

//        threadA.setUncaughtExceptionHandler(handler);//желательно каждой нити отдельно назначить хэндлер
//        threadB.setUncaughtExceptionHandler(handler);

        threadA.start();// выполняется метод run() объекта, который передан ему в конструктор (TestThread)
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {

        public TestedThread(UncaughtExceptionHandler handler) {
            setDefaultUncaughtExceptionHandler(handler);
            start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
