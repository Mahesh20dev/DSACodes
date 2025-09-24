 //Palindrome Number
    public static void Palindrome(int number) {
        int originalNo = number;
        int reversedNo = 0;
        while(originalNo != 0) {
            int remainder = originalNo % 10;
            reversedNo = reversedNo * 10 + remainder;
            originalNo /= 10;
        }
        if(reversedNo == number) {
            System.out.println(number + " is a Palindrome number");
        } else {
            System.out.println(number + " is not a Palindrome number");
        }
    }
    public static void main1(String[] args) {
        int number = 121;  // Change this to test other numbers
        Palindrome(number);
    }
    // Time: O(d) (d is the number of digits in the number)
    // Space: O(1)




    // if String is input
    int number = 123;
    String str = String.valueOf(number);
    System.out.println(str);  // "123"



    
    // Palindrome check for String input
     public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // Palindrome
    }
    public static void main2(String[] args) {
        String str = "121"; // You can directly take user input as string here
        if (isPalindrome(str)) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is not a Palindrome");
        }

    }
    // Time: O(n) (n is the length of the string)
    // Space: O(1)

   

    


   

