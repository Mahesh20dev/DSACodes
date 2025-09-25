// Buble sort
import java.util.Scanner;
public class Practise2 {
    
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};

        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
//explanation: In bubble sort, we repeatedly compare adjacent elements and swap them if they are in the wrong order. This process is repeated until the entire array is sorted. The algorithm gets its name from the way smaller elements "bubble" to the top of the array with each pass.
//In the worst case, when the array is sorted in reverse order, bubble sort will require O(n^2) comparisons and swaps to sort the array. This is because each element will need to be compared with every other element in the array.
//In the average case, when the elements are in a jumbled order, bubble sort will also require O(n^2) comparisons and swaps to sort the array. This is because, on average, each element will need to be compared with half of the other elements in the array.
//In the best case, when the array is already sorted, bubble sort will only require O(n) comparisons and no swaps to confirm that the array is already sorted. This is because each element will only need to be compared with its adjacent element once.



