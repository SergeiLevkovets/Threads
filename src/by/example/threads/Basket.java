package by.example.threads;

public class Basket {

  private int productsCount;

  public Basket(int productsCount) {
    this.productsCount = productsCount;
  }

  int takeProduct() {
    return --productsCount;
  }

  synchronized int takeProductSync() {
    return --productsCount;
  }
}
