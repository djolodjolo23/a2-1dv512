import java.util.concurrent.Semaphore;

public class WorkerB implements Runnable{

  final Semaphore semaphore;

  public WorkerB(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    synchronized (semaphore) {
      int counter = 0;
      while (counter < 10) {
        try {
          semaphore.acquire();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println("B");
        counter++;
        semaphore.release();
        semaphore.notify();
      }
    }
  }
}

