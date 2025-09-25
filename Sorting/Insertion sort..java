// Insertion sort.
import java.util.Scanner;
public class Pattern1 {

    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};

        for(int i=1; i<arr.length; i++) {

            int current = arr[i];
            int j = i-1;

            while(j>=0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
        printArray(arr);
    }
}
// Time complexity: O(n^2)
// Space complexity: O(1)
// example: 7,8,3,1,2
// output: 1,2,3,7,8
//explanation: Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
// It is a stable, in-place, comparison-based sorting algorithm. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
