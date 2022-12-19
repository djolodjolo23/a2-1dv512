import java.util.concurrent.Semaphore;

public class WorkerB extends SuperWorker implements Runnable{

  final Semaphore semaphore;

  public WorkerB(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  @Override
  public void run() {
    synchronized (semaphore) {
      run(semaphore, "B");
    }
  }
}

