import java.util.*;

public class Map1 {
    public static void main(String[] args) {

        System.out.println("=== HashMap ===");
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(3, "Three");
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(1, "Uno"); // Overwrites value for key 1, keys cannot be duplicate
        hashMap.put(null, "NullKey"); // Allowed in HashMap
        System.out.println("HashMap: " + hashMap); // No guaranteed order

        System.out.println("\n=== LinkedHashMap ===");
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(null, "NullKey"); // Allowed
        System.out.println("LinkedHashMap (insertion order): " + linkedHashMap);

        System.out.println("\n=== TreeMap ===");
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        // treeMap.put(null, "NullKey");  Will throw NullPointerException
        System.out.println("TreeMap (sorted by keys): " + treeMap);

        System.out.println("\n=== Accessing and Checking ===");
        System.out.println("hashMap.get(1): " + hashMap.get(1));
        System.out.println("treeMap.containsKey(2): " + treeMap.containsKey(2));
        System.out.println("linkedHashMap.containsValue(\"Two\"): " + linkedHashMap.containsValue("Two"));

        System.out.println("\n=== Removing ===");
        hashMap.remove(1);
        System.out.println("hashMap after remove: " + hashMap);

        System.out.println("\n=== Iterating through Entries via For ===");
        //linkedHashMap.entrySet() returns a Set of Map.Entry<K, V> objects.
        // Map.Entry<K, V> Represents one key-value pair, also has entry.setValue(newValue)
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("\n=== Iterating via Lambda ===");
        treeMap.forEach((key, value) ->
            System.out.println("Key: " + key + ", Value: " + value));

        System.out.println("\n=== KeySet, Values, and EntrySet ===");
        System.out.println("Keys in TreeMap: " + treeMap.keySet());
        System.out.println("Values in TreeMap: " + treeMap.values());
        System.out.println("Entries in TreeMap: " + treeMap.entrySet());

        System.out.println("\n=== Replace and Clear ===");
        linkedHashMap.replace(2, "Two (Updated)");
        System.out.println("linkedHashMap after replace: " + linkedHashMap);
        linkedHashMap.clear();
        System.out.println("linkedHashMap after clear: " + linkedHashMap);
    }
}