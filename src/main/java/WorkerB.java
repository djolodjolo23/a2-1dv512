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
        AppendedString.addToString("B");
        counter++;
        semaphore.release();
        semaphore.notify();
        if (counter == 10) {
          break;
        }
        try {
          semaphore.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}

