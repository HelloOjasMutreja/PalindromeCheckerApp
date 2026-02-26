import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";

        // Normalize (optional but fair for all strategies)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Input : " + input);

        // Warm-up (helps reduce JVM warm-up noise)
        for (int i = 0; i < 1000; i++) {
            isPalindromeTwoPointer(normalized);
            isPalindromeStack(normalized);
            isPalindromeDeque(normalized);
        }

        // Benchmark Two-Pointer
        long start = System.nanoTime();
        boolean r1 = isPalindromeTwoPointer(normalized);
        long end = System.nanoTime();
        long t1 = end - start;

        // Benchmark Stack
        start = System.nanoTime();
        boolean r2 = isPalindromeStack(normalized);
        end = System.nanoTime();
        long t2 = end - start;

        // Benchmark Deque
        start = System.nanoTime();
        boolean r3 = isPalindromeDeque(normalized);
        end = System.nanoTime();
        long t3 = end - start;

        // Display results
        System.out.println("Two-Pointer Result : " + r1 + " | Time : " + t1 + " ns");
        System.out.println("Stack Result       : " + r2 + " | Time : " + t2 + " ns");
        System.out.println("Deque Result       : " + r3 + " | Time : " + t3 + " ns");
    }

    // -----------------------------
    // Algorithm 1: Two-Pointer
    // -----------------------------
    static boolean isPalindromeTwoPointer(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // -----------------------------
    // Algorithm 2: Stack-based
    // -----------------------------
    static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (stack.pop() != c) return false;
        }
        return true;
    }

    // -----------------------------
    // Algorithm 3: Deque-based
    // -----------------------------
    static boolean isPalindromeDeque(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}