//https://leetcode.com/problems/daily-temperatures/description/

class Solution {
    class Pair {
        int temperature;
        int index;
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Pair> stack = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.getFirst().temperature < temperatures[i]) {
                Pair pair = stack.removeFirst();
                res[pair.index] = i - pair.index;
            }
            Pair newPair = new Pair();
            newPair.temperature = temperatures[i];
            newPair.index = i;
            stack.addFirst(newPair);
        }
        return res;
    }
}
