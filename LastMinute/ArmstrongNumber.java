 //Armstrong Number
    public class ArmstrongNumber {
    public static void ArmStrong(int number, int n) {
        int result = 0;
        int originalNo = number;
        while(originalNo != 0) {
            int remainder = originalNo % 10;
            result += Math.pow(remainder, n);
            originalNo /= 10;
        }
        if(result == number) {
            System.out.println(number + " is an Armstrong number");
        } else {
            System.out.println(number + " is not an Armstrong number");
        }
    }
    public static void main(String[] args) {
        int number = 153;  // Change this to test other numbers
        int n = String.valueOf(number).length();
        ArmStrong(number, n);
    }


    // if String is input
    String numStr = "153";
    int number = Integer.parseInt(numStr);
    int n = numStr.length();
    ArmStrong(number, n);
    // Time: O(d) (d is the number of digits in the number)
    // Space: O(1)


    OR


    
    // if String is input
    public static void ArmStrongString(String numStr) {
    int n = numStr.length();
    int result = 0;
    
    for (int i = 0; i < n; i++) {
        int digit = numStr.charAt(i) - '0'; // Convert char to int
        result += Math.pow(digit, n);
    }

    int originalNo = Integer.parseInt(numStr); // Only for final comparison

    if (result == originalNo) {
        System.out.println(numStr + " is an Armstrong number");
    } else {
        System.out.println(numStr + " is not an Armstrong number");
    }
    }

    public static void main(String[] args) {
        String numStr = "153"; // You can directly take user input as string here
        ArmStrongString(numStr);
    }