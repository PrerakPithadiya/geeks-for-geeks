
class Solution {

    /**
     * Calculates the amount of water that can be trapped between blocks.
     *
     * @param arr An array of integers representing the height of each block.
     * @return The total amount of water that can be trapped.
     */
    static long trappingWater(int arr[]) {
        int n = arr.length;

        // Base case: If there are less than 3 blocks, no water can be trapped
        if (n < 3) {
            return 0;
        }

        // Create arrays to store the maximum height to the left and right of each block
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill the leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Fill the rightMax array
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate the total trapped water
        long totalWater = 0;
        for (int i = 0; i < n; i++) {
            // Water trapped on top of the current block
            totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        // Test the trappingWater function with example cases
        int[] arr1 = {3, 0, 0, 2, 0, 4};
        System.out.println("Test Case 1: " + trappingWater(arr1));  // Expected Output: 10

        int[] arr2 = {7, 4, 0, 9};
        System.out.println("Test Case 2: " + trappingWater(arr2));  // Expected Output: 10

        int[] arr3 = {6, 9, 9};
        System.out.println("Test Case 3: " + trappingWater(arr3));  // Expected Output: 0

        // Additional test cases
        int[] arr4 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test Case 4: " + trappingWater(arr4));  // Expected Output: 6

        int[] arr5 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test Case 5: " + trappingWater(arr5));  // Expected Output: 9

        int[] arr6 = {1, 2};
        System.out.println("Test Case 6: " + trappingWater(arr6));  // Expected Output: 0 (less than 3 blocks)

        int[] arr7 = {};
        System.out.println("Test Case 7: " + trappingWater(arr7));  // Expected Output: 0 (empty array)
    }
}
