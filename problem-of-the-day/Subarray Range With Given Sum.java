
import java.util.HashMap;

class Solution {

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
        int[] arr1 = {10, 2, -2, -20, 10};
        int tar1 = -10;
        System.out.println(subarraySum(arr1, tar1)); // Output: 3

        int[] arr2 = {1, 4, 20, 3, 10, 5};
        int tar2 = 33;
        System.out.println(subarraySum(arr2, tar2)); // Output: 1
    }
}
