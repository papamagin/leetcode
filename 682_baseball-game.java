//https://leetcode.com/problems/baseball-game/description/

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : operations) {
            if (s.equals("+")) {
                int first = stack.removeFirst();
                int second = stack.getFirst();
                stack.addFirst(first);
                stack.addFirst(first + second);
            } else if (s.equals("D")) {
                int prev = stack.getFirst();
                stack.addFirst(prev*2);
            } else if (s.equals("C")) {
                stack.removeFirst();
            } else {
                stack.addFirst(Integer.parseInt(s));
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.removeFirst();
        }

        return res;
    }
}
