package by.example.threads;

/**
 * Получение информации о потоке.
 */
public class ThreadsExample1 {

  public static void main(String[] args) {
    Thread mainThread = Thread.currentThread();
    String threadName = mainThread.getName();
    System.out.println("Thread name: " + threadName);
    System.out.println("Thread info: " + mainThread);
  }
}
