import java.util.*;

public class List1 {

    public static void main(String[] args) {
        // Create ArrayList and LinkedList
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        System.out.println("=== Adding Elements ===");
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add(1, "Blueberry"); // Insert at index

        // arrayList.add(1.2); // results in error, as type is specified as String
        // If type was not specified it could be any object and would be known 
        // at runtime only, this type safety is by Generic
        
        System.out.println("ArrayList: " + arrayList);

        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Fox");
        linkedList.add(2, "Giraffe"); // Insert at index
        System.out.println("LinkedList: " + linkedList);

        System.out.println("\n=== Accessing Elements ===");
        System.out.println("arrayList.get(1): " + arrayList.get(1));
        System.out.println("linkedList.get(2): " + linkedList.get(2));

        System.out.println("\n=== Updating Elements ===");
        arrayList.set(0, "Avocado");
        linkedList.set(1, "Eagle");
        System.out.println("ArrayList (after update): " + arrayList);
        System.out.println("LinkedList (after update): " + linkedList);

        System.out.println("\n=== Removing Elements ===");
        // Can be removed using Element name or index
        arrayList.remove("Banana");
        arrayList.remove(1);
        linkedList.remove("Dog");
        linkedList.remove(1);
        System.out.println("ArrayList (after remove): " + arrayList);
        System.out.println("LinkedList (after remove): " + linkedList);

        System.out.println("\n=== Searching ===");
        System.out.println("arrayList.contains(\"Cherry\"): " + arrayList.contains("Cherry"));
        // indexOf() returns first occurence index
        System.out.println("linkedList.indexOf(\"Fox\"): " + linkedList.indexOf("Fox"));

        System.out.println("\n=== Iterating ===");
        System.out.print("ArrayList: ");
        for (String s : arrayList) 
            System.out.print(s + " ");
        
        System.out.print("\nLinkedList with Iterator: ");
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");

        System.out.print("\nLinkedList with For: ");
        for(String l:linkedList)
            System.out.print(l + " ");
        
        System.out.println("\n\n=== Conversion to Array ===");
        Object[] array = arrayList.toArray();
        System.out.println("ArrayList as Array: " + Arrays.toString(array));

        System.out.println("\n=== Size and IsEmpty ===");
        System.out.println("arrayList.size(): " + arrayList.size());
        System.out.println("linkedList.isEmpty(): " + linkedList.isEmpty());

        System.out.println("\n=== Clear ===");
        arrayList.clear();
        linkedList.clear();
        System.out.println("ArrayList after clear: " + arrayList);
        System.out.println("LinkedList after clear: " + linkedList);

        // Extra: LinkedList specific methods
        System.out.println("\n=== LinkedList Specific Methods ===");
        LinkedList<String> ll = new LinkedList<>();
        ll.addFirst("One");
        ll.addLast("Three");
        ll.add(1, "Two");
        System.out.println("LinkedList with addFirst/addLast: " + ll);
        System.out.println("First: " + ll.getFirst());
        System.out.println("Last: " + ll.getLast());
        ll.removeFirst();
        ll.removeLast();
        System.out.println("LinkedList after removeFirst/removeLast: " + ll);
    }
}
