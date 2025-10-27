class Task1 extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Task 1-Count: " + i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Task2 extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Task 2-Count: " + i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Threads {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        // long endTime = System.nanoTime();
        // Long duration = endTime- startTime;
    }

}