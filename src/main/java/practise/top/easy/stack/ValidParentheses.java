package practise.top.easy.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Input: s = "]"
 * Output: false
 * <p>
 * https://leetcode.com/problems/valid-parentheses/solutions/173832/valid-parentheses/
 */
public class ValidParentheses {
    /**
     * Time complexity : O(n) because we simply traverse the given string one character at a time
     * and push and pop operations on a stack take O(1)O(1)O(1) time.
     * Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
     * we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
     */
    public boolean isValid(String s) {
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(maps.containsKey(c)){
                if(stack.empty()||stack.pop()!=maps.get(c))return false;
            }
            else
                stack.push(c);
        }
        return stack.empty();
    }
}
