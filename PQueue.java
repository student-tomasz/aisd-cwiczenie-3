public interface PQueue<T extends Comparable<T>> {
  public void insert(T o); // inserts o into the queue
  public T remove();       // removes object with highest priority (by natural order)
}
