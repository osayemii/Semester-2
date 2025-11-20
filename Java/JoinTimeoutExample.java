public class JoinTimeoutExample {
    public static void main(String[] args) throws InterruptedException {
        Task t1 = new Task();
        t1.setName("Daniel's task");
        t1.start();
        t1.join(1000);
        System.out.println("Main thread resumes after"+ t1.getName() +" completes.");
    }
}

class Task extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println("From task: "+getName()+ ", Count "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}