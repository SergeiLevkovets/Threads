package by.example.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Несколько потоков работают с общим ресурсом и последовательно (с помощью synchronized блока) изменяют его состояние.
 */
public class ThreadsExample6 {

  public static void main(String[] args) {
    System.out.printf("[%s] Starting main thread\n", Thread.currentThread().getName());

    Basket basket = new Basket(10);
    List<SyncOnBasketCustomer> customers = new ArrayList<>();
    for (int i = 1; i <= 3; i++) {
      customers.add(new SyncOnBasketCustomer("Customer " + i, basket));
    }

    for (SyncOnBasketCustomer customer : customers) {
      new Thread(customer).start();
    }

    System.out.printf("[%s] Main thread is finished\n", Thread.currentThread().getName());
  }
}
