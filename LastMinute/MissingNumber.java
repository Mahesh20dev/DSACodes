 // Missing Number in Array
    public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // Example array
        int n = arr.length + 1;      // Total numbers should be n (1 to n)

        // Step 1: Calculate expected sum of 1 to n using formula n*(n+1)/2
        int totalSum = n * (n + 1) / 2;

        // Step 2: Find actual sum of elements in array
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }

        // Step 3: Missing number = totalSum - actualSum
        int missingNumber = totalSum - actualSum;
        System.out.println("Missing Number: " + missingNumber);
    }
}
    // Time: O(n) (to calculate the sum of array elements)
    // Space: O(1) (only a few extra variables used)