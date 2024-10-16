
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    /**
     * Splits a linked list into two sub-lists, one containing nodes at even
     * indices and the other containing nodes at odd indices from the original
     * list.
     *
     * @param head The head of the original linked list
     * @return An array of two Node objects, representing the heads of the two
     * sub-lists
     */
    public Node[] alternatingSplitList(Node head) {
        // Dummy nodes for both sub-lists
        Node dummy1 = new Node(0); // Sub-list for even indexed nodes
        Node dummy2 = new Node(0); // Sub-list for odd indexed nodes

        Node curr1 = dummy1; // Pointer for sub-list 1
        Node curr2 = dummy2; // Pointer for sub-list 2

        Node current = head; // Start from the head of the original list
        int index = 0; // Index to determine even or odd

        while (current != null) {
            if (index % 2 == 0) {
                curr1.next = current; // Add to sub-list 1
                curr1 = curr1.next;   // Move the pointer
            } else {
                curr2.next = current; // Add to sub-list 2
                curr2 = curr2.next;   // Move the pointer
            }
            current = current.next; // Move to the next node
            index++;
        }

        // Terminate the two sub-lists
        curr1.next = null;
        curr2.next = null;

        // Return the heads of the two sub-lists
        return new Node[]{dummy1.next, dummy2.next};
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty list
        Node[] result1 = solution.alternatingSplitList(null);
        printTestResult(1, result1[0] == null && result1[1] == null);

        // Test case 2: Single node
        Node singleNode = new Node(1);
        Node[] result2 = solution.alternatingSplitList(singleNode);
        printTestResult(2, result2[0] != null && result2[0].data == 1 && result2[1] == null);

        // Test case 3: Even number of nodes
        Node evenList = createLinkedList(new int[]{1, 2, 3, 4});
        Node[] result3 = solution.alternatingSplitList(evenList);
        printTestResult(3, verifyList(result3[0], new int[]{1, 3}) && verifyList(result3[1], new int[]{2, 4}));

        // Test case 4: Odd number of nodes
        Node oddList = createLinkedList(new int[]{1, 2, 3, 4, 5});
        Node[] result4 = solution.alternatingSplitList(oddList);
        printTestResult(4, verifyList(result4[0], new int[]{1, 3, 5}) && verifyList(result4[1], new int[]{2, 4}));
    }

    // Helper method to create a linked list from an array
    private static Node createLinkedList(int[] arr) {
        Node dummy = new Node(0);
        Node current = dummy;
        for (int value : arr) {
            current.next = new Node(value);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to verify if a list matches expected values
    private static boolean verifyList(Node head, int[] expected) {
        Node current = head;
        for (int value : expected) {
            if (current == null || current.data != value) {
                return false;
            }
            current = current.next;
        }
        return current == null;
    }

    // Helper method to print test results
    private static void printTestResult(int testNumber, boolean passed) {
        System.out.println("Test case " + testNumber + ": " + (passed ? "Passed" : "Failed"));
    }
}
