package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEx {

    public static void main(String[] args) throws InterruptedException {

        Task task = new Task();

        Thread thread1 = new Thread(() -> task.firstThread());
        Thread thread2 = new Thread(() -> task.firstThread());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();
    }

    private static class Task {

        private int counter;
        private Lock lock = new ReentrantLock();

        public void increment() {
            for (int i = 0; i < 10_000; i++) {
                counter++;
            }
        }

        public void firstThread() {
            locker();
        }

        public void secondThread() {
            locker();
        }

        private void locker() {
            lock.lock();
            increment();
            lock.unlock();
        }

        public void showCounter() {
            System.out.println(counter);
        }
    }
}
