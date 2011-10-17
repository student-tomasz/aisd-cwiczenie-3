import java.util.Map;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultimap;

public class PQueueOnTreeMultimap<P extends Comparable<P>, T extends Comparable<T>> implements PQueue<P, T> {

  private Multimap<P, T> mmap;

  public PQueueOnTreeMultimap() {
    Ordering<P> priority_ordering = Ordering.natural().reverse(); // daje to kolejność od największego priorytetu w porządku naturalnym
    Ordering<T> value_ordering = Ordering.natural();
    mmap = TreeMultimap.create(priority_ordering, value_ordering);
  }

  public void insert(P priority, T value) {
    mmap.put(priority, value);
  }

  public T remove() {
    if (mmap.size() <= 0) {
      return null;
    }
    Map.Entry<P, T> top_entry = mmap.entries().iterator().next();
    T output = top_entry.getValue();

    mmap.remove(top_entry.getKey(), top_entry.getValue());

    return output;
  }

}
