public class Daemon {
    public static void main(String[] args) {
        DaemonThread dt1 = new DaemonThread();
        dt1.setDaemon(true);
        dt1.start();

        if (dt1.isDaemon()) {
            System.out.println("Daemon in background...");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main user thread DONE!");
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        int i = 1;
        while (true) {
            System.out.println("Daemon is working: " + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
