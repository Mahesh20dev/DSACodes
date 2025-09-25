// Selection sort.
import java.lang.Math;
import java.util.Scanner;
public class Pattern {
    
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {7,8,3,1,2};

        for(int i=0; i<arr.length-1; i++) {
            int smallest = i;

            for(int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(1)
//worst case: when array is sorted in reverse order
//average case: when elements are in jumbled order
//best case: when array is already sorted
//example: 1 2 8 7 3
//Output: 1 2 3 7 8
//explanation: In selection sort, we repeatedly find the minimum element from the unsorted part of the array and swap it with the first unsorted element. This process is repeated until the entire array is sorted.
//In the worst case, when the array is sorted in reverse order, selection sort will require O(n^2) comparisons to sort the array. This is because each element will need to be compared with every other element in the array.
//In the average case, when the elements are in a jumbled order, selection sort will also require O(n^2) comparisons to sort the array. This is because, on average, each element will need to be compared with half of the other elements in the array.
//In the best case, when the array is already sorted, selection sort will still require O(n^2) comparisons to confirm that the array is already sorted. This is because each element will still need to be compared with every other element in the array.