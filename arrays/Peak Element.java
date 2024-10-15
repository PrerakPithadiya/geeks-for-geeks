
/**
 * This class provides a solution to find a peak element in an array.
 * A peak element is an element that is greater than or equal to its neighbors.
 * The solution uses a binary search approach to efficiently find a peak element.
 */
class Solution {

    /**
     *
     * Finds a peak element in the given array using binary search.
     *
     * @param arr The input array
     * @param n The length of the array
     * @return The index of a peak element, or -1 if no peak element is found
     *
     * Time Complexity: O(log n), where n is the length of the array Space
     * Complexity: O(1), as it uses only a constant amount of extra space
     */
    public static int peakElement(int[] arr, int n) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            boolean isPeak = (mid == 0 || arr[mid] >= arr[mid - 1])
                    && (mid == n - 1 || arr[mid] >= arr[mid + 1]);

            if (isPeak) {
                return mid; // Found a peak element
            }

            // Move to the direction of the larger neighbor
            if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }

        return -1; // This should never happen if n >= 1
    }

    /**
     * Main method to demonstrate the usage of the peakElement function. It
     * includes several test cases to showcase different scenarios.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Example test cases
        int[] arr1 = {1, 2, 3};
        System.out.println("Test case 1: " + peakElement(arr1, arr1.length)); // Output: 2

        int[] arr2 = {1, 1, 1, 2, 1, 1, 1};
        System.out.println("Test case 2: " + peakElement(arr2, arr2.length)); // Output: 3 or other peak indices

        // Additional test cases
        int[] arr3 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Test case 3: " + peakElement(arr3, arr3.length)); // Output: 5

        int[] arr4 = {1};
        System.out.println("Test case 4: " + peakElement(arr4, arr4.length)); // Output: 0

        int[] arr5 = {1, 2};
        System.out.println("Test case 5: " + peakElement(arr5, arr5.length)); // Output: 1

        int[] arr6 = {2, 1};
        System.out.println("Test case 6: " + peakElement(arr6, arr6.length)); // Output: 0

        int[] arr7 = {1, 3, 20, 4, 1, 0};
        System.out.println("Test case 7: " + peakElement(arr7, arr7.length)); // Output: 2
    }
}
