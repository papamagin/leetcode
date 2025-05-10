//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for(String t : tokens) {
            if (t.equals("+")) {
                int first = stack.removeFirst();
                int second = stack.removeFirst();
                stack.addFirst(second + first);
            } else if (t.equals("-")) {
                int first = stack.removeFirst();
                int second = stack.removeFirst();
                stack.addFirst(second - first);
            } else if (t.equals("*")) {
                int first = stack.removeFirst();
                int second = stack.removeFirst();
                stack.addFirst(second * first);
            } else if (t.equals("/")) {
                int first = stack.removeFirst();
                int second = stack.removeFirst();
                stack.addFirst(second / first);
            } else {
                stack.addFirst(Integer.parseInt(t));
            }
        }

        return stack.removeFirst();
    }
}
