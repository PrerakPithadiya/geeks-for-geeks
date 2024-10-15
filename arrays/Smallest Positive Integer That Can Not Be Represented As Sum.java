
import java.util.Arrays;

/**
 * This class contains a solution to find the smallest positive integer that
 * cannot be represented as the sum of any subset of a given array.
 */
class Solution {

    /**
     * Finds the smallest positive integer that cannot be represented as the sum
     * of any subset of the given array.
     *
     * @param array The input array of long integers
     * @param n The size of the input array
     * @return The smallest positive integer that cannot be represented as a sum
     */
    public long smallestpositive(long[] array, int n) {
        // Sort the array
        Arrays.sort(array);

        // Initialize the smallest positive number we cannot form
        long res = 1;

        // Traverse the sorted array
        for (int i = 0; i < n; i++) {
            // If the current element is larger than the smallest number we can't form, break
            if (array[i] > res) {
                break;
            }
            // Otherwise, add the current element to res
            res += array[i];
        }

        // Return the smallest positive number we cannot form
        return res;
    }

    /**
     * Main method to run test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        long[] arr1 = {1, 1, 1};
        System.out.println("Test case 1: " + solution.smallestpositive(arr1, arr1.length));
        // Expected output: 4

        // Test case 2
        long[] arr2 = {1, 2, 3, 4};
        System.out.println("Test case 2: " + solution.smallestpositive(arr2, arr2.length));
        // Expected output: 11

        // Test case 3
        long[] arr3 = {1, 2, 5, 10, 20, 40};
        System.out.println("Test case 3: " + solution.smallestpositive(arr3, arr3.length));
        // Expected output: 4

        // Test case 4
        long[] arr4 = {1, 1, 3, 4};
        System.out.println("Test case 4: " + solution.smallestpositive(arr4, arr4.length));
        // Expected output: 10
    }
}
