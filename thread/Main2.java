class SharedData {
    private int data;
    private boolean hasData;

    public synchronized void produce(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume(int value) {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumed: "+data);
        hasData = false;
        notify();
    }
}

public class Main2 {

    public static void main(String[] args) {
        SharedData data = new SharedData();

        Thread producer = new Thread(() -> {
            for (int i = 0; i >= 5; i++) {
                data.produce(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consume = new Thread(() -> {
            for (int i = 0; i <= 5; i++) {
                data.consume(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consume.start();
    }
}