package multithreading;

public class PingPong {

    public static void main(String[] args) {

        Printer printer = new Printer();

        new Thread(() -> {
            printer.printOne();
        }).start();

        new Thread(printer::printTwo).start();
    }

    public static class Printer {

        private String currentWord = "Ping";

        public synchronized void printOne() {
            for (int i = 0; i < 10; i++) {
                while (!currentWord.equals("Ping")) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(currentWord + "\n");
                currentWord = "Pong";
                notify();
            }
        }

        public synchronized void printTwo() {
            for (int i = 0; i < 10; i++) {
                while (!currentWord.equals("Pong")) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(currentWord + "\n");
                currentWord = "Ping";
                notify();
            }
        }
    }
}
