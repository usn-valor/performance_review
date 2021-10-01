package multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<Integer> future = service.submit(() -> {
            System.out.println("Starting");
            Thread.sleep(500);
            System.out.println("Finished");

            Random random = new Random();
            int value = random.nextInt();

            if (value < 5)
                throw new Exception("Something bad happened");
            return random.nextInt(10);
        });

        service.shutdown();

        try {
            int result = future.get(); // ожидается окончание выполнения потока. Затем проверяются исключения и достается значение
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}
