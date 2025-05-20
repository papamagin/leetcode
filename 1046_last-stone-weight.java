//https://leetcode.com/problems/last-stone-weight/description/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones) {
            q.offer(i);
        }
        while(q.size() > 1) {
            int s1 = q.poll();
            int s2 = q.poll();
            if (s1 - s2 > 0) {
                q.offer(s1 - s2);
            }
        }
        return q.isEmpty() ? 0 : q.peek();
    }
}
