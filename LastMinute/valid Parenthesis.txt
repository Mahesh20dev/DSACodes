import java.util.Stack;
class Solution {
    public Character brackets(Character clobracks){
        switch(clobracks){
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return null;
    }
    public boolean isValid(String s) {
        Stack<Character> set=new Stack<>();
        for(Character bracket:s.toCharArray()){
            switch(bracket){
                case '(':
                case '[':
                case '{':
                    set.push(bracket);
                    break;
                case ')':
                case ']':
                case '}':
                    if(set.isEmpty()){
                        return false;
                    }
                    Character top=set.pop();
                    if(top!=brackets(bracket)){
                        return false;
                    }
            }
        }
            
         
        return set.isEmpty();
    }
}