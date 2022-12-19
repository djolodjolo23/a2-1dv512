import java.util.concurrent.Semaphore;

public class WorkerA extends SuperWorker implements Runnable{

  final Semaphore semaphore;

  public WorkerA(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    synchronized (semaphore) {
      semaphore.release();
      run(semaphore, "A");
    }
  }
}
