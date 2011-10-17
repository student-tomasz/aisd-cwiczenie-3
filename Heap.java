import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> implements PQueue<T> {

  private int count; // kopiec zaczyna się na 1
  private T[] array;

  // Bardzo brzydki hax0r na 'dynamicznego' genericsa. Wymagane jest podanie
  // klasy do T jako argumentu konstruktora. Bardzo się wstydzę. Serio. Jest
  // to jednak bardziej type safe niż trzymanie Object[].
  @SuppressWarnings("unchecked")
  public Heap(Class<T> klass) {
    count = 0;
    array = (T[]) Array.newInstance(klass, 1);
  }

  public void insert(T o) {
    if (count+1 == array.length) array = Arrays.copyOf(array, array.length*2);

    array[++count] = o;
    up(count);
  }

  public T remove() {
    T output = array[1];

    array[1] = array[count];
    array[count] = null;
    count--;
    down(1);

    return output;
  }

  private void up(int i) {
    T tmp;

    while (i/2 >= 1 && array[i/2].compareTo(array[i]) < 0) {
      tmp = array[i];
      array[i] = array[i/2];
      array[i/2] = tmp;
      i = i/2;
    }
  }

  private void down(int i) {
    T tmp;
    int lc, rc, c;

    while (true) {
      lc = 2*i;
      rc = 2*i+1;
      c = i;

      if (lc <= count && array[lc].compareTo(array[i]) > 0)
        c = lc;
      if (rc <= count && array[rc].compareTo(array[c]) > 0)
        c = rc;

      if (c != i) {
        tmp = array[i];
        array[i] = array[c];
        array[c] = tmp;
        i = c;
      }
      else {
        break;
      }
    }
  }

  public String toString() {
    String output = "";
    for (int i = 0; i < array.length; i++) {
      output += array[i] + " ";
    }
    return output;
  }

}
