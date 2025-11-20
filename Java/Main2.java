public class Main2 {
    public static void main(String[] args) {
        // Thread t1 = new Thread(new MThread());
        // System.out.println("Before starting...");
        // t1.start();
        // System.out.println("After starting...");

        // WORKER
        Worker worker = new Worker();
        worker.start();
        try {
            worker.join();
            System.out.println("Thread " + worker.getName() + " is still alive");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // while (worker.isAlive()) {
        // System.out.println("Thread "+ worker.getName() + " is still alive");
        // try {
        // Thread.sleep(500);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }
    }
}

class MThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

class Worker extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println("Worker name: " + getName() + " process count " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
