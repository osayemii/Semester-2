class InnerMyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

class SleepDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " is running, step " + i);
            try {
                // Thread goes to TIME_WAITING state for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class MyThread {
    public static void main(String[] args) {
        SleepDemo sDemo1 = new SleepDemo();
        sDemo1.setName("Worker-1");
        sDemo1.start();
        while (sDemo1.isAlive()) {
            System.out.println("Current state of: "+sDemo1.getName()+" is "+sDemo1.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n-------------------------------------------------\n");

        // Create a thread instance
        InnerMyThread t1 = new InnerMyThread();
        System.out.println("First state: " + t1.getState());

        // Start the thread
        t1.start();
        System.out.println("After invoking start() method: " + t1.getState());

        // Wait for it to finish
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check the state after completion
        System.out.println("After completion: " + t1.getState());
    }
}
