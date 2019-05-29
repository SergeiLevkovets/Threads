package by.example.threads;

/**
 * Создание и запуск потока, главный поток ждет выполнения дочернего.
 */
public class ThreadsExample3 {

  public static void main(String[] args) throws InterruptedException {
    System.out.printf("[%s] Starting main thread\n", Thread.currentThread().getName());
    Thread thread = new Thread(new SleepingRunnable(100));
    thread.start();
    thread.join();
    System.out.printf("[%s] Main thread is finished\n", Thread.currentThread().getName());
  }
}
