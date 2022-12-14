import java.util.concurrent.Semaphore;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Semaphore semaphore = new Semaphore(0);

    WorkerA wa = new WorkerA(semaphore);
    Thread ta = new Thread(wa);

    WorkerB wb = new WorkerB(semaphore);
    Thread tb = new Thread(wb);
    ta.start();
    tb.start();

    ta.join();
    tb.join();

    System.out.println(AppendedString.getFinalString());



///
  }
}