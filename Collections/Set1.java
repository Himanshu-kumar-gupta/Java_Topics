import java.util.*;

public class Set1 {
    public static void main(String[] args) {

        System.out.println("=== HashSet ===");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // duplicate
        hashSet.add(null); // only 1 null allowed, as duplicates are not allowed
        System.out.println("HashSet: " + hashSet); // No order

        System.out.println("\n=== LinkedHashSet ===");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Apple"); // duplicate
        linkedHashSet.add(null);
        System.out.println("LinkedHashSet: " + linkedHashSet); // Insertion order

        System.out.println("\n=== TreeSet ===");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Cherry");
        treeSet.add("Apple"); // duplicate
        // treeSet.add(null);  Will throw NullPointerException
        System.out.println("TreeSet (sorted): " + treeSet); // Sorted order

        // Common Set Methods
        System.out.println("\n=== Common Operations ===");
        System.out.println("treeSet.contains(\"Apple\"): " + treeSet.contains("Apple"));
        treeSet.remove("Banana");
        System.out.println("treeSet after remove: " + treeSet);

        System.out.println("\nIterating with for-each:");
        for (String item : hashSet) {
            System.out.print(item + " ");
        }

        System.out.println("\n\nIterating with Iterator:");
        Iterator<String> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\n\n=== Conversion to Array ===");
        Object[] arr = treeSet.toArray();
        System.out.println("TreeSet as array: " + Arrays.toString(arr));

        System.out.println("\n=== Size and Clear ===");
        System.out.println("linkedHashSet size: " + linkedHashSet.size());
        linkedHashSet.clear();
        System.out.println("linkedHashSet after clear: " + linkedHashSet);
    }
}