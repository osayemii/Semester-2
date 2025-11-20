import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}

class Counter {
    AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }
}

class Printer {
    synchronized void printJob(String message) {
        synchronized (this) {
            for (int i = 1; i <= 3; i++) {
                System.out.println(message + ' ' + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
