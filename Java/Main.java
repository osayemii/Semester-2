class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Running in Thread: "+Thread.currentThread().getName());
    }
}

class DownloadManager extends Thread {
    private int fileSize;

    public DownloadManager(int fileSize){
        this.fileSize = fileSize;
    }

    public void run(){
        System.out.println(getName() + " started downloading...");

        for(int i=0; i<=fileSize; i+=20) {
            System.out.println(getName() + " downloaded "+ i + "%");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName()+" was cancelled!!");
                return;
            }
        }
        System.out.println("Download completed successfully");
    }

}


public class Main {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        Thread.currentThread().setName("Default"); //To change the current Thread name
        m1.setName("Worker-1");
        m1.start();
        m1.run();

        DownloadManager d1 = new DownloadManager(100);
        d1.setName("Sportify");
        d1.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {}

        d1.interrupt();
        System.out.println("User clicked cancel...");
    }
}
