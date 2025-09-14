// Heap DS insert, peek, remove (sigma)
import java.util.*;
public class Main {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {      // O(logn)
            arr.add(data);    // O(1)

            int x = arr.size()-1;  // x is the child index
            int par = (x-1)/2; // par index

            while(arr.get(x) < arr.get(par)) {     // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            // checking left < arr.size() = is minIdx leaf node 
            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {  
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if(minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // if below elements got unbalanced
                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);
            
            // step 1 - swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2 - remove last element
            arr.remove(arr.size()-1);

            // step 3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(1);
        pq.add(4);
        pq.add(2);
        pq.add(7);

        while(!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }

        // if u want to print reverse or create Max heap just change the logic
        // one is in add method change the less than to greater than and change in heapify method ( in left and right checking)
        // and also change the name minIdx -> maxIdx
        // thats it aasaaan hai
    }
}