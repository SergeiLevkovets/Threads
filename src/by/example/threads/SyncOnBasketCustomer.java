package by.example.threads;

import java.util.Random;

public class SyncOnBasketCustomer implements Runnable {

  private final String name;
  private final Basket basket;
  private final long sleepMillis = Math.abs(new Random().nextLong() % 50);

  public SyncOnBasketCustomer(String name, Basket basket) {
    this.name = name;
    this.basket = basket;
  }

  @Override
  public void run() {
    int remainingProductsCount = 0;

    do {
      synchronized (basket) {
        remainingProductsCount = basket.takeProduct();
      }

      if (remainingProductsCount > 0) {
        System.out.printf("Customer '%s' took product, remaining products count: %s\n", name, remainingProductsCount);
      }

      try {
        Thread.sleep(sleepMillis);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (remainingProductsCount > 0);
  }
}
