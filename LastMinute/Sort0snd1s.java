// Sort Binary Array
    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Move left pointer if it's already 0
            while (arr[left] == 0 && left < right) {
                left++;
            }
            // Move right pointer if it's already 1
            while (arr[right] == 1 && left < right) {
                right--;
            }
            // Swap when left is 1 and right is 0
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));  // Output: [0, 0, 0, 1, 1, 1, 1]
    }
    // Time: O(n) (each element is processed at most once)
    // Space: O(1) (in-place sorting)