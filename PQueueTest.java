public class PQueueTest {
  public static void main(String[] args) {
    Double[] testArray = new Double[] {-12.0, 14.0, 5.3, 1.0, 6.0, -10.0, 8.2, 0.1101, 3.1415, 14.0, 14.1};
    PQueue<Double> queue = new Heap<Double>(Double.class);

    for (int i = 0; i < testArray.length; i++) {
      queue.insert(testArray[i]);
    }

    System.out.print("before heapsort:\n");
    for (int i = 0; i < testArray.length; i++) {
      System.out.print("" + testArray[i] + " ");
    }
    System.out.println();

    System.out.print("after heapsort:\n");
    for (int i = 0; i < testArray.length; i++) {
      // System.out.print("\n" + ((Heap<Double>)queue).toString() + "\n");
      System.out.print("" + queue.remove() + " ");
    }
    System.out.println();
  }
}
