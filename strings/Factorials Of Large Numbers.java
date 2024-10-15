
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class provides a solution for calculating factorials of large numbers.
 * It uses an ArrayList to store individual digits of the factorial result.
 */
class Solution {

    /**
     * Calculates the factorial of a given number N.
     *
     * @param N The number for which factorial is to be calculated.
     * @return An ArrayList of integers representing the digits of N!.
     */
    public static ArrayList<Integer> factorial(int N) {
        // Initialize a list to store digits of the factorial
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1); // Start with 1 for 0! and 1!

        // Iterate from 2 to N
        for (int i = 2; i <= N; i++) {
            multiply(result, i);
        }

        // Result is built in correct order
        Collections.reverse(result);
        return result;
    }

    /**
     * Multiplies the current result by an integer.
     *
     * @param result The current factorial result stored as digits.
     * @param x The integer to multiply with.
     */
    private static void multiply(ArrayList<Integer> result, int x) {
        int carry = 0; // Initialize carry
        for (int i = 0; i < result.size(); i++) {
            int prod = result.get(i) * x + carry; // Multiply and add carry
            result.set(i, prod % 10); // Update digit in result
            carry = prod / 10; // Calculate new carry
        }

        // Handle remaining carry
        while (carry > 0) {
            result.add(carry % 10); // Add remaining carry as new digits
            carry /= 10;
        }
    }

    /**
     * Main method to test the factorial calculation.
     */
    public static void main(String[] args) {
        // Test case 1: Factorial of 5
        System.out.println("Factorial of 5: " + factorial(5));
        // Expected output: [1, 2, 0]

        // Test case 2: Factorial of 10
        System.out.println("Factorial of 10: " + factorial(10));
        // Expected output: [3, 6, 2, 8, 8, 0, 0]

        // Test case 3: Factorial of 20
        System.out.println("Factorial of 20: " + factorial(20));
        // Expected output: [2, 4, 3, 2, 9, 0, 2, 0, 0, 8, 1, 7, 6, 6, 4, 0, 0, 0]

        // Test case 4: Factorial of 0
        System.out.println("Factorial of 0: " + factorial(0));
        // Expected output: [1]

        // Test case 5: Factorial of 1
        System.out.println("Factorial of 1: " + factorial(1));
        // Expected output: [1]
    }
}
