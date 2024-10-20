
/**
 * Solution class for finding the longest proper prefix which is also a proper suffix.
 */
class Solution {

    /**
     * Computes the length of the longest proper prefix which is also a proper
     * suffix.
     *
     * @param str The input string
     * @return The length of the longest proper prefix-suffix
     */
    public static int lps(String str) {
        int n = str.length();
        int[] lps = new int[n];  // LPS array to store the lengths

        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;

        // LPS for first character is always 0
        lps[0] = 0;

        // Build the LPS array
        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // Mismatch after some matches
                if (length != 0) {
                    // Do not increment 'i' here; try matching with previous prefix-suffix
                    length = lps[length - 1];
                } else {
                    // No match found, set lps[i] to 0 and move to next character
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // The length of the longest proper prefix which is also a suffix is stored at lps[n-1]
        return lps[n - 1];
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        // Test case 1
        String str1 = "abab";
        System.out.println("Test case 1:");
        System.out.println("Input: " + str1);
        System.out.println("Output: " + lps(str1));
        System.out.println("Expected: 2");

        // Test case 2
        String str2 = "aaaa";
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + str2);
        System.out.println("Output: " + lps(str2));
        System.out.println("Expected: 3");

        // Test case 3
        String str3 = "abcab";
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + str3);
        System.out.println("Output: " + lps(str3));
        System.out.println("Expected: 2");

        // Test case 4
        String str4 = "abababa";
        System.out.println("\nTest case 4:");
        System.out.println("Input: " + str4);
        System.out.println("Output: " + lps(str4));
        System.out.println("Expected: 5");

        // Test case 5
        String str5 = "abc";
        System.out.println("\nTest case 5:");
        System.out.println("Input: " + str5);
        System.out.println("Output: " + lps(str5));
        System.out.println("Expected: 0");
    }
}
