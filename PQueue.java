public interface PQueue<P extends Comparable<P>, T extends Comparable<T>> {
  public void insert(P priority, T value); // inserts value into the queue
  public T remove();                       // removes value with highest priority (by natural order)
}
