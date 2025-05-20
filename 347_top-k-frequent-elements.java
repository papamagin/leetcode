//https://leetcode.com/problems/top-k-frequent-elements/description/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int i : nums) {
            freqs.putIfAbsent(i, 0);
            freqs.put(i, freqs.get(i) + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> freqs.get(a) - freqs.get(b));
        for (int i : freqs.keySet()) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        int n = q.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}
