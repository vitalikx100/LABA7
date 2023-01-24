package threads;

import java.util.concurrent.Semaphore;

public class Integrator extends Thread {

    private final Task tasks;
    private final Semaphore semaphore;

    public Integrator(Task tasks, Semaphore semaphore) {
        this.tasks = tasks;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        double result = tasks.integral();
        System.out.println("Result = " + result + " ");
        semaphore.release();
    }
}
