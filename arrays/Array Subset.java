
import java.util.HashMap;

/**
 * This class provides a method to check if one array is a subset of another.
 */
class Compute {

    /**
     * Checks if array a2 is a subset of array a1.
     *
     * @param a1 The first array (potential superset)
     * @param a2 The second array (potential subset)
     * @param n The length of array a1
     * @param m The length of array a2
     * @return "Yes" if a2 is a subset of a1, "No" otherwise
     */
    public String isSubset(long a1[], long a2[], long n, long m) {
        // Create a frequency map for elements in a1
        HashMap<Long, Long> frequencyMap = new HashMap<>();

        // Count occurrences of each element in a1
        for (long i = 0; i < n; i++) {
            frequencyMap.put(a1[(int) i], frequencyMap.getOrDefault(a1[(int) i], 0L) + 1);
        }

        // Check if each element in a2 is present in the frequency map
        for (long j = 0; j < m; j++) {
            // If the element is not found or its count is exhausted, return "No"
            if (!frequencyMap.containsKey(a2[(int) j]) || frequencyMap.get(a2[(int) j]) <= 0) {
                return "No";
            }
            // Decrease the count for the found element
            frequencyMap.put(a2[(int) j], frequencyMap.get(a2[(int) j]) - 1);
        }

        // If all elements of a2 are found in a1, return "Yes"
        return "Yes";
    }

    public static void main(String[] args) {
        Compute compute = new Compute();

        // Test case 1: a2 is a subset of a1
        long[] a1 = {11, 7, 1, 13, 21, 3, 7, 3};
        long[] a2 = {11, 3, 7, 1, 7};
        System.out.println("Test case 1: " + compute.isSubset(a1, a2, a1.length, a2.length));  // Expected output: Yes

        // Test case 2: a2 is a subset of a1 with repeated elements
        long[] a1_2 = {1, 2, 3, 4, 4, 5, 6};
        long[] a2_2 = {1, 2, 4};
        System.out.println("Test case 2: " + compute.isSubset(a1_2, a2_2, a1_2.length, a2_2.length));  // Expected output: Yes

        // Test case 3: a2 is not a subset of a1
        long[] a1_3 = {10, 5, 2, 23, 19};
        long[] a2_3 = {19, 5, 3};
        System.out.println("Test case 3: " + compute.isSubset(a1_3, a2_3, a1_3.length, a2_3.length));  // Expected output: No

        // Test case 4: Empty subset
        long[] a1_4 = {1, 2, 3, 4, 5};
        long[] a2_4 = {};
        System.out.println("Test case 4: " + compute.isSubset(a1_4, a2_4, a1_4.length, a2_4.length));  // Expected output: Yes

        // Test case 5: Identical arrays
        long[] a1_5 = {1, 2, 3, 4, 5};
        long[] a2_5 = {1, 2, 3, 4, 5};
        System.out.println("Test case 5: " + compute.isSubset(a1_5, a2_5, a1_5.length, a2_5.length));  // Expected output: Yes

        // Test case 6: Subset with more occurrences than superset
        long[] a1_6 = {1, 2, 3, 3, 4, 5};
        long[] a2_6 = {3, 3, 3};
        System.out.println("Test case 6: " + compute.isSubset(a1_6, a2_6, a1_6.length, a2_6.length));  // Expected output: No
    }
}
