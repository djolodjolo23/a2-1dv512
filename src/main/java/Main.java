import java.util.concurrent.Semaphore;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    // starting the intial permits as 0 so the worker A can get to job first
    // worker A releases one permit at the start of the run().
    Semaphore semaphore = new Semaphore(0);

    WorkerA wa = new WorkerA(semaphore);
    Thread ta = new Thread(wa);

    WorkerB wb = new WorkerB(semaphore);
    Thread tb = new Thread(wb);
    ta.start();
    tb.start();

    ta.join();
    tb.join();


  }
}