
/**
 * Solution class to find the row with the maximum number of 1s in a binary matrix.
 */
class Solution {

    /**
     * Finds the index of the row with the maximum number of 1s in a binary
     * matrix.
     *
     * @param arr The input 2D binary array where each row is sorted in
     * non-decreasing order.
     * @return The index of the row with the maximum number of 1s, or -1 if the
     * matrix is empty.
     */
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length; // Number of rows
        if (n == 0) {
            return -1; // If there are no rows
        }
        int m = arr[0].length; // Number of columns
        int maxCount = 0; // Maximum count of 1s found
        int rowIndex = -1; // Index of the row with maximum 1s

        // Start from the top-right corner of the matrix
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (arr[row][col] == 1) {
                // If we find a 1, we move left to check for more 1s in the same row
                col--;
                // Update maxCount and rowIndex if this row has more 1s
                if (m - 1 - col > maxCount) {
                    maxCount = m - 1 - col;
                    rowIndex = row;
                }
            } else {
                // If we find a 0, move down to the next row
                row++;
            }
        }

        return rowIndex; // Return the index of the row with the maximum 1s
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case
        int[][] arr1 = {
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };
        System.out.println("Test case 1: " + solution.rowWithMax1s(arr1)); // Expected output: 2

        // Test case 2: Empty matrix
        int[][] arr2 = {};
        System.out.println("Test case 2: " + solution.rowWithMax1s(arr2)); // Expected output: -1

        // Test case 3: Matrix with no 1s
        int[][] arr3 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Test case 3: " + solution.rowWithMax1s(arr3)); // Expected output: -1

        // Test case 4: Matrix with all 1s
        int[][] arr4 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        System.out.println("Test case 4: " + solution.rowWithMax1s(arr4)); // Expected output: 0

        // Test case 5: Matrix with 1s in the last column
        int[][] arr5 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 1, 1}
        };
        System.out.println("Test case 5: " + solution.rowWithMax1s(arr5)); // Expected output: 3
    }
}
