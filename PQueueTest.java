public class PQueueTest {

  public static void main(String[] args) {
    String[] words = new String[] {
      "kto Cię stracił.",
      "Ojczyzno moja,",
      "Litwo,",
      "ty jesteś jak zdrowie",
      "ten tylko się dowie",
      "ile cię trzeba cenić,"
    };
    Integer[] priorities = new Integer[] {
      0,
      100,
      100,
      60,
      20,
      40
    };

    PQueue<Integer, String> queue = new PQueueOnTreeMultimap<Integer, String>();
    for(int i = 0; i < words.length; i++) {
      queue.insert(priorities[i], words[i]);
    }

    System.out.println();
    System.out.println("before:");
    for (int i = 0; i < words.length; i++) {
      System.out.print("" + words[i] + " ");
    }
    System.out.println();

    System.out.println("after:");
    for (int i = 0; i < words.length; i++) {
      System.out.print("" + queue.remove() + " ");
    }
    System.out.println();
  }

}
