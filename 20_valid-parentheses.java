//https://leetcode.com/problems/valid-parentheses/description/

class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.removeFirst() != '(') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.removeFirst() != '[') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.removeFirst() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
