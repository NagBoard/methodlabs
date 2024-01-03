import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Define the number of elements and number of insertions
        int countOfElements = 100000;
        int countForInsert = 1000;

        // Create ArrayList and LinkedList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Fill the lists with random integers
        fillList(arrayList, countOfElements, "ArrayList");
        fillList(linkedList, countOfElements, "LinkedList");

        // Perform random access on the lists
        randomAccess(arrayList, countOfElements, "ArrayList");
        randomAccess(linkedList, countOfElements, "LinkedList");

        // Perform sequential access on the lists
        sequentialAccess(arrayList, "ArrayList");
        sequentialAccess(linkedList, "LinkedList");

        // Insert elements at the beginning of the lists
        insertAtBeginning(arrayList, countForInsert, "ArrayList");
        insertAtBeginning(linkedList, countForInsert, "LinkedList");

        // Insert elements at the center of the lists
        insertAtCenter(arrayList, countForInsert, "ArrayList");
        insertAtCenter(linkedList, countForInsert, "LinkedList");

        // Insert elements at the end of the lists
        insertAtEnd(arrayList, countForInsert, "ArrayList");
        insertAtEnd(linkedList, countForInsert, "LinkedList");
    }

    // Fill the list with random integers
    private static void fillList(List<Integer> list, int n, String listType) {
        Random random = new Random();

        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt());
        }

        System.out.printf("Fill %s: %s %n", listType, System.currentTimeMillis() - time);
    }

    // Perform random access on the list
    private static void randomAccess(List<Integer> list, int n, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int value = list.get(i);
        }
        System.out.printf("Random access %s: %s %n", listType, System.currentTimeMillis() - time);
    }

    // Perform sequential access on the list
    private static void sequentialAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
        }
        System.out.printf("Sequential access %s: %s %n", listType, System.currentTimeMillis() - time);
    }

    // Insert elements at the beginning of the list
    private static void insertAtBeginning(List<Integer> list, int n, String listType) {
        Random random = new Random();

        long time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(0, random.nextInt(n));
        }
        System.out.printf("Insert at the beginning of %s: %d %n", listType, System.currentTimeMillis() - time);
    }

    // Insert elements at the end of the list
    private static void insertAtEnd(List<Integer> list, int n, String listType) {
        long time = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(n));
        }
        System.out.printf("Insert at the end of %s: %d %n", listType, System.currentTimeMillis() - time);
    }

    // Insert elements at the center of the list
    private static void insertAtCenter(List<Integer> list, int n, String listType) {
        Random random = new Random();

        long time = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < n; i++) {
            list.add(size / 2, random.nextInt(n));
        }
        System.out.printf("Insert in the middle of %s: %d %n", listType, System.currentTimeMillis() - time);
    }
}