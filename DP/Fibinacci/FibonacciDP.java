public class FibonacciDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        int[] fib = new int[n+1];
        if (n > 0) fib[0] = 0;
        if (n > 1) fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }
    }
}
// Time: O(n) (linear time complexity)
// Space: O(n) (for the array storing Fibonacci numbers)  