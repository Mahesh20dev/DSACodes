class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Step 1: Check if we have k nodes
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        if (count < k) return head; // fewer than k nodes left

        // Step 2: Reverse k nodes
        ListNode prev = null, curr = head, next = null;
        count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: Recurse for remaining list
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Step 4: Return new head
        return prev;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create sample linked list: 1→2→3→4→5→6→7→8
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original list:");
        printList(head);

        int k = 3;
        head = reverseKGroup(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        printList(head);
    }
}
