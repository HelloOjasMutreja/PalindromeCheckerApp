public class PalindromeCheckerApp {

    // Node definition for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Helper to build a linked list from a string
    static Node buildList(String s) {
        if (s == null || s.isEmpty()) return null;
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    // Reverse a linked list and return new head
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // Check if the linked list is a palindrome
    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalfHead = reverse(slow);

        // Compare first half and reversed second half
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean result = true;
        while (p2 != null) { // only need to compare till end of second half
            if (p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return result;
    }

    public static void main(String[] args) {
        // Define input
        String input = "level";

        // Convert string to linked list
        Node head = buildList(input);

        // Check palindrome
        boolean isPal = isPalindrome(head);

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPal);
    }
}