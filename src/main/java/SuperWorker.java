import java.util.concurrent.Semaphore;

public abstract class SuperWorker {

  public void run(Semaphore semaphore, String letter) {
    int counter = 0;
    while (counter < 10) {
      try {
        semaphore.acquire();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      AppendedString.addToString(letter);
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
