import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "level";

        // Choose strategy at runtime
        PalindromeStrategy strategy;

        // You can switch strategies here:
        // strategy = new StackStrategy();
        strategy = new DequeStrategy();

        // Execute selected strategy
        boolean isPalindrome = strategy.check(input);

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

// =======================
// STRATEGY INTERFACE
// =======================
interface PalindromeStrategy {
    boolean check(String input);
}

// =======================
// STACK-BASED STRATEGY
// =======================
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;

        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop and compare
        for (char c : input.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }
}

// =======================
// DEQUE-BASED STRATEGY
// =======================
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;

        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // Compare front and rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}