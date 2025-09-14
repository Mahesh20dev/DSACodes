// Valid Anagram (HashMap) sigma
import java.util.*;
public class DSA {
    public static boolean validAnagram(String s, String t) {   // T = O(2n) , S = O(n)
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch)-1);
                if(mp.get(ch) == 0) {
                    mp.remove(ch);
                }
            } else {
                return false;
            }
        }
        return mp.isEmpty();
    }
    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        System.out.println(validAnagram(s, t));
    }
}       