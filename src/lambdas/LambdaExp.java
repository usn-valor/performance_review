package lambdas;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LambdaExp {

    public static void main(String[] args) throws InterruptedException {

        SecureLock lock = new SecureLock();

        Thread t1 = new Thread(() -> {
            lock.doWork();
        });

//        t1.setDaemon(true);

        Thread t2 = new Thread(lock::doWork);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(lock.getCount());
    }

    private static class SecureLock {

        private final Lock lock = new ReentrantLock();
        private int count;

        public int getCount() {
            return count;
        }

        public void doWork() {
            lock.lock();
            counter();
            lock.unlock();
        }

        private void counter() {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }
    }
}
