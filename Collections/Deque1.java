import java.util.*;

public class Deque1 {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        System.out.println("=== Adding Elements ===");
        // offer and add methods family do the same thing and offer() add() always add backwards 
        deque.add("Apple");
        deque.addFirst("Banana");
        deque.addLast("Cherry");
        deque.offer("Date");
        deque.add("Jamun");
        deque.offerFirst("Elderberry");
        deque.offerLast("Fig");
        System.out.println("Deque: " + deque);

        System.out.println("\n=== Accessing Elements ===");
        System.out.println("First Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());
        System.out.println("Peek First: " + deque.peekFirst());
        System.out.println("Peek Last: " + deque.peekLast());

        System.out.println("\n=== Removing Elements ===");
        deque.removeFirst();  // removes Elderberry
        deque.removeLast();   // removes Fig
        deque.pollFirst();    // removes Banana
        deque.pollLast();     // removes Jamun
        System.out.println("Deque after removals: " + deque);

        System.out.println("\n=== Contains, Size, and isEmpty ===");
        System.out.println("Contains 'Apple': " + deque.contains("Apple"));
        System.out.println("Deque size: " + deque.size());
        System.out.println("Is deque empty?: " + deque.isEmpty());

        System.out.println("\n=== Stack-like Operations ===");
        deque.push("Push1");
        deque.push("Push2");
        System.out.println("Deque after push: " + deque);
        System.out.println("pop(): " + deque.pop());
        System.out.println("Deque after pop: " + deque);
        
        System.out.println("\n=== Iterating Forwards ===");
        for (String fruit : deque) {
            System.out.println(fruit);
        }

        System.out.println("\n=== Iterating Backwards ===");
        Iterator<String> descItr = deque.descendingIterator();
        while (descItr.hasNext()) {
            System.out.println(descItr.next());
        }

        System.out.println("\n=== Clearing Deque ===");
        deque.clear();
        System.out.println("Deque after clear: " + deque);
    }
}
