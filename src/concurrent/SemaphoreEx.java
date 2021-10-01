package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreEx {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(200);

        Connection connection = Connection.connection.getConnection();
        for (int i = 0; i < 200; i++) {
            service.submit(() -> {
                try {
                    connection.work();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }

    private static class Connection {

        private static Connection connection = new Connection();
        private int connectionCount;
        private Semaphore semaphore = new Semaphore(10);

        public Connection getConnection() {
            return connection;
        }

        public void work() throws InterruptedException {
            semaphore.acquire();
            try {
                doWork();
            } finally {
                semaphore.release(); /* release() должен вызываться в блоки finally, потому что блок try может окончиться
                выбрасыванием исключения, и до этого метода дело не дойдет. Соответственно не освободится одно право на ресурс*/
            }
        }

        private void doWork() throws InterruptedException {
            synchronized (this) {
                connectionCount++;
                System.out.println(connectionCount);
            }

            Thread.sleep(5000);

            synchronized (this) {
                connectionCount--;
            }
        }
    }
}
