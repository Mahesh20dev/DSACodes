// subArray sum equal to K (hashMap) sigma
import java.util.*;
public class Revision2 {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};    // ans = 3
        int k = -10;

        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;

        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Subarray sum equal to "+ k + " is = " + ans);
    }
}

// Time ans Space complexity = O(n)
// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2