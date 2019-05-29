package by.example.threads;

public class SleepingRunnable implements Runnable {

  private final int sleepMillis;

  public SleepingRunnable(int sleepMillis) {
    this.sleepMillis = sleepMillis;
  }

  @Override
  public void run() {
    final Thread currentThread = Thread.currentThread();
    System.out.printf("[%s] Starting sleeping runnable\n", currentThread.getName());
    try {
      Thread.sleep(sleepMillis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("[%s] Sleeping runnable is finished\n", currentThread.getName());
  }
}
