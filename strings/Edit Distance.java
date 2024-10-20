
/**
 * Solution class for calculating the Edit Distance between two strings.
 */
class Solution {

    /**
     * Calculates the minimum number of operations required to convert str1 to
     * str2. The allowed operations are: 1. Insert a character 2. Delete a
     * character 3. Replace a character
     *
     * @param str1 The first string
     * @param str2 The second string
     * @return The minimum number of operations required to convert str1 to str2
     */
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // DP table to store the minimum edit distances
        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  // Convert str1[0..i-1] to an empty string by deleting all characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  // Convert an empty string to str2[0..j-1] by inserting all characters
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // No operation needed if the characters are the same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take the minimum of insert, delete, and replace operations
                    dp[i][j] = Math.min(dp[i - 1][j], // Delete
                            Math.min(dp[i][j - 1], // Insert
                                    dp[i - 1][j - 1])) + 1;  // Replace
                }
            }
        }

        // Return the result from the bottom-right corner of the DP table
        return dp[m][n];
    }

    /**
     * Main method to run test cases for the editDistance method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty strings
        assert solution.editDistance("", "") == 0 : "Test case 1 failed";

        // Test case 2: One empty string
        assert solution.editDistance("abc", "") == 3 : "Test case 2 failed";
        assert solution.editDistance("", "abc") == 3 : "Test case 3 failed";

        // Test case 4: Same strings
        assert solution.editDistance("hello", "hello") == 0 : "Test case 4 failed";

        // Test case 5: Different strings
        assert solution.editDistance("kitten", "sitting") == 3 : "Test case 5 failed";

        // Test case 6: Strings with different lengths
        assert solution.editDistance("sunday", "saturday") == 3 : "Test case 6 failed";

        System.out.println("All test cases passed successfully!");
    }
}
