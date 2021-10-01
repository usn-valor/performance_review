package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchEx {

//    public static void main(String[] args) throws InterruptedException {
//
//        CountDownLatch latch = new CountDownLatch(3);
//
//        ExecutorService service = Executors.newFixedThreadPool(3);
//
//        for (int i = 0; i < 3; i++) {
//            service.submit(() -> {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                latch.countDown();
//            });
//        }
//
//        service.shutdown();
//        latch.await();
//        System.out.println("Latch has been opened, main thread is proceeding!");
//    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            service.submit(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.printf("Thread with id %d proceeded!\n", finalI);
            });
        }

        service.shutdown();
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            latch.countDown();
        }
    }
}
