public class lcm {
    int x = 12, y = 18;
    int gcd = 1;
    for(int i = 1; i <= x && i <= y; i++) {
    if(x % i == 0 && y % i == 0) gcd = i;
    }
    int lcm = (x * y) / gcd;
    System.out.println("LCM: " + lcm);
}
