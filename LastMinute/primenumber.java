 // Prime Number
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime
        }

        // Only need to check up to √number
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // divisible by i, not prime
            }
        }
        // Loop from 2 to √number (because if a number has a factor > √n, it must also have a factor < √n).
        return true; // no divisors found, number is prime
    }
    public static void main3(String[] args) {
        int number = 29; // Change this to test other numbers
        if (isPrime(number)) {
            System.out.println(number + " is a prime number");
        } else {
            System.out.println(number + " is not a prime number");
        }
    }
    // Time: O(√n) (n is the input number)
    // Space: O(1)