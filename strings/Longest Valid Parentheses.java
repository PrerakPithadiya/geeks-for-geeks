
import java.util.Stack;

/**
 * Solution class for finding the length of the longest valid parentheses
 * substring.
 */
class Solution {

    /**
     * Finds the length of the longest valid parentheses substring in the given
     * string.
     *
     * @param str The input string containing parentheses.
     * @return The length of the longest valid parentheses substring.
     */
    static int maxLength(String str) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;

        // Push -1 onto the stack to handle base case for valid substring length
        stack.push(-1);

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == '(') {
                // Push the index of the opening parenthesis
                stack.push(i);
            } else {
                // Current character is ')'
                stack.pop(); // Pop the last opening parenthesis index

                if (stack.isEmpty()) {
                    // If the stack is empty, push the current index as a new base
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    int validLength = i - stack.peek();
                    maxLength = Math.max(maxLength, validLength);
                }
            }
        }

        return maxLength;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        // Test case 1: Basic valid parentheses
        String test1 = "()()";
        System.out.println("Test 1: " + maxLength(test1)); // Expected output: 4

        // Test case 2: Nested valid parentheses
        String test2 = "(()())";
        System.out.println("Test 2: " + maxLength(test2)); // Expected output: 6

        // Test case 3: Invalid parentheses
        String test3 = ")(";
        System.out.println("Test 3: " + maxLength(test3)); // Expected output: 0

        // Test case 4: Mixed valid and invalid parentheses
        String test4 = ")()())";
        System.out.println("Test 4: " + maxLength(test4)); // Expected output: 4

        // Test case 5: Empty string
        String test5 = "";
        System.out.println("Test 5: " + maxLength(test5)); // Expected output: 0

        // Test case 6: Long string with multiple valid substrings
        String test6 = "()(()))))((((()())()";
        System.out.println("Test 6: " + maxLength(test6)); // Expected output: 6
    }
}
