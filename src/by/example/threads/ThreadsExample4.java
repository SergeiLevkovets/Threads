package by.example.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Несколько потоков работают с общим ресурсом и одновременно изменяют его состояние.
 */
public class ThreadsExample4 {

  public static void main(String[] args) {
    System.out.printf("[%s] Starting main thread\n", Thread.currentThread().getName());

    Basket basket = new Basket(10);
    List<Customer> customers = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
      customers.add(new Customer("Customer " + i, basket, false));
    }

    for (Customer customer : customers) {
      final Thread customerThread = new Thread(customer);
      customerThread.start();
    }

    System.out.printf("[%s] Main thread is finished\n", Thread.currentThread().getName());
  }
}
