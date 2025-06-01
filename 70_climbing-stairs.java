//https://leetcode.com/problems/climbing-stairs/description/

class Solution {
    Map<Integer, Integer> mem = new HashMap<>();
    public int climbStairs(int n) {
        mem.put(1, 1);
        mem.put(2, 2);
        return rec(n);
    }
    private int rec(int n) {
        if (mem.get(n) != null) {
            return mem.get(n);
        }
        mem.put(n, rec(n - 2) + rec(n - 1));
        return mem.get(n);
    }
}
