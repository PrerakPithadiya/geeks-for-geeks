
class Solution {

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

    public static void main(String[] args) {
        // Example test cases
        int[] arr1 = {1, 2, 3};
        System.out.println(peakElement(arr1, arr1.length)); // Output: 2

        int[] arr2 = {1, 1, 1, 2, 1, 1, 1};
        System.out.println(peakElement(arr2, arr2.length)); // Output: 3 or other peak indices
    }
}
