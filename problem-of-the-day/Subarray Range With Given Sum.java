
import java.util.HashMap;

/**
 * This class provides a solution for finding the number of subarrays with a
 * given sum.
 */
class Solution {

    /**
     * Finds the number of subarrays in the given array that sum up to the
     * target value.
     *
     * @param arr The input array of integers.
     * @param tar The target sum.
     * @return The number of subarrays with the given sum.
     */
    public static int subarraySum(int[] arr, int tar) {
        // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();

        // Initialize prefix sum and count of subarrays
        int prefixSum = 0;
        int count = 0;

        // Base case: prefix sum 0 has been seen once
        prefixSumFreq.put(0, 1);

        // Traverse the array
        for (int num : arr) {
            // Update the prefix sum
            prefixSum += num;

            // Check if (prefixSum - tar) is already in the map
            if (prefixSumFreq.containsKey(prefixSum - tar)) {
                count += prefixSumFreq.get(prefixSum - tar);
            }

            // Update the frequency of the current prefix sum in the map
            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {10, 2, -2, -20, 10};
        int tar1 = -10;
        System.out.println(subarraySum(arr1, tar1)); // Expected output: 3

        // Test case 2
        int[] arr2 = {1, 4, 20, 3, 10, 5};
        int tar2 = 33;
        System.out.println(subarraySum(arr2, tar2)); // Expected output: 1

        // Test case 3: Empty array
        int[] arr3 = {};
        int tar3 = 0;
        System.out.println(subarraySum(arr3, tar3)); // Expected output: 0

        // Test case 4: Array with all zeros
        int[] arr4 = {0, 0, 0, 0};
        int tar4 = 0;
        System.out.println(subarraySum(arr4, tar4)); // Expected output: 10

        // Test case 5: Array with negative numbers
        int[] arr5 = {-1, -1, 1};
        int tar5 = 0;
        System.out.println(subarraySum(arr5, tar5)); // Expected output: 1

        // Test case 6: Large array
        int[] arr6 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr6[i] = i % 10;
        }
        int tar6 = 15;
        System.out.println(subarraySum(arr6, tar6)); // Expected output depends on the array content
    }
}
