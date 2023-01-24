package threads;

public class SimpleIntegrator implements Runnable {
    private final Task tasks;

    public SimpleIntegrator(Task tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        double result = tasks.integral();
        System.out.println("Result = " + result + " ");
    }
}
