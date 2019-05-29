package by.example.threads;

import java.util.Random;

public class Customer implements Runnable {

  private final String name;
  private final Basket basket;
  private final boolean isSynchronized;
  private final long sleepMillis = Math.abs(new Random().nextLong() % 50);

  public Customer(String name, Basket basket, boolean isSynchronized) {
    this.name = name;
    this.basket = basket;
    this.isSynchronized = isSynchronized;
  }

  @Override
  public void run() {
    int remainingProductsCount = 0;

    while ((remainingProductsCount = isSynchronized ? basket.takeProductSync() : basket.takeProduct()) > 0) {
      System.out.printf("Customer '%s' took product, remaining products count: %s\n", name, remainingProductsCount);

      try {
        Thread.sleep(sleepMillis);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
