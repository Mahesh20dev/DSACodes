public class sumofdigits {
    int n = 1234, sum = 0;
    while(n != 0) {
    sum += n % 10;
    n /= 10;
    }
    System.out.println("Sum of digits: " + sum);

}
