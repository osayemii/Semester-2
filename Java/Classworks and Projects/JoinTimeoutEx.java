public class JoinTimeoutEx {
    public static void main(String[] args) throws InterruptedException {
        Inner t1 = new Inner();
        Inner t2 = new Inner();
        Inner t3 = new Inner();

        t1.setName("Task1");
        t2.setName("Task2");
        t3.setName("Task3");

        t1.start();
        t1.join(3000);
        t2.start();
        t3.start();
    }
}

class Inner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(getName() + " Count: "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
