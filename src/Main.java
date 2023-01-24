import functions.basic.*;
import threads.Generator;
import threads.SimpleGenerator;
import threads.Task;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {nonThread();}

    private static void nonThread() {
        int numberOfTasks = 100;
        Random rand = new Random();
        for (int i = 0; i < numberOfTasks; ++i) {
            double base = rand.nextDouble() * 9 + 1;
            double left = rand.nextDouble() * 100;
            double right = rand.nextDouble() * 100 + 100;
            double step = rand.nextDouble();
            System.out.println("Test #" + (i + 1));
            System.out.println("Left = " + left + ", Right = " + right + ", Step = " + step + ", base = " + base);
            Task task = new Task(new Log(base), left, right, step, 1);
            double result = task.integral();
            System.out.println("Result = " + result );
        }
    }

    private static void simpleThreads() {
        Thread thread = new Thread(new SimpleGenerator(new Task(100)));
        thread.start();
    }

    private static void complicatedThreads() {
        Semaphore semaphore = new Semaphore(1);
        Thread thread = new Generator(new Task(100), semaphore);
        thread.start();
        try {
            Thread.sleep(50);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}