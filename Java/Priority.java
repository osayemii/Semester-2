class ThreadClass extends Thread {
    public String name;
    public int id;

    public ThreadClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.id + " " + this.name + " is starting...");
        try {
            for (int i = 0; i <= 20; i++) {
                int percent = (int) (((double)i / 20) * 100);
                System.out.println("Thread " + this.id + " " + this.name + " is " + percent +"% completed.");
                Thread.sleep(500*i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + this.id + " " + this.name + " processed successfully!!");
    }
}

class PriorityCheck extends Thread {
    @Override
    public void run(){
        System.out.println(getName()+" Priority -> "+ getPriority());
    }    
}

public class Priority {
    public static void main(String[] args) {
        ThreadClass t1 = new ThreadClass("First value", 1);
        ThreadClass t2 = new ThreadClass("Second value", 2);
        ThreadClass t3 = new ThreadClass("Third value", 3);

        t3.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Thread-1 "+t1.getPriority());
        System.out.println("Thread-2 "+t2.getPriority());
        System.out.println("Thread-3 "+t3.getPriority());

        t1.start();
        t2.start();
        t3.start();

        //PRIORITY CHECK
        System.out.println("Main thread priority: "+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        PriorityCheck p1 = new PriorityCheck();
        PriorityCheck p2 = new PriorityCheck();

        p1.setName("Worker-1");
        p2.setName("Worker-2");

        p1.start();
        p2.start();
    }
}