public class DaemonThread {
    public static void main(String[] args) {
        DaemonWorker dw1 = new DaemonWorker();
        dw1.setDaemon(true);
        dw1.start();

        System.out.println("Main user thread working...");
        if (dw1.isDaemon()) {
            System.out.println("Daemon thread is running in background");
        } else System.out.println("Another user thread is running in background!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int count = 1;
        while (count <= 10) {
            System.out.println("Count: "+count);
            try {
                Thread.sleep(1000);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Main user thread DONE!");
    }
}

class DaemonWorker extends Thread {
    @Override
    public void run() {
        int processCount = 1;
        while (processCount <= 8) {
            System.out.println("Daemon thread running process: " + processCount);
            try {
                Thread.sleep(1000);
                processCount++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
