// Fractional Snapsack - Greedy algorithm (sigma)
import java.util.*;

public class Practice {
    public static void main(String[] args) {
        int val[] = {10, 5, 15, 7, 6, 18, 3};
        int weight[] = {2, 3, 5, 7, 1, 4, 1};
        int W = 15;
        double ratio[][] = new double[val.length][2];

        for(int i=0; i<val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double)weight[i];
        }

        // sort
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        double finalVal = 0;     // can take int

        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]) {
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Max capacity is "+ finalVal);
    }
}