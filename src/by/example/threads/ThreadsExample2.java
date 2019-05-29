package by.example.threads;

/**
 * Создание и запуск потока, главный поток не ждет пока дочерний поток отработает.
 */
public class ThreadsExample2 {

  public static void main(String[] args) {
    System.out.printf("[%s] Starting main thread\n", Thread.currentThread().getName());
    new Thread(new SleepingRunnable(100)).start();

    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("[%s] Main thread is finished\n", Thread.currentThread().getName());
  }
}
