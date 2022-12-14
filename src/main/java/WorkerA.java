import java.util.concurrent.Semaphore;

public class WorkerA implements Runnable{

  final Semaphore semaphore;

  public WorkerA(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    synchronized (semaphore) {
      semaphore.release();
      int counter = 0;
      while (counter < 10) {
        try {
          semaphore.acquire();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("A");
        counter++;
        semaphore.release();
        semaphore.notify();
     }
    }
  }
}
