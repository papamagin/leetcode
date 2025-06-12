//https://leetcode.com/problems/maximum-frequency-stack/description/

public class FreqStack {
    Map<Integer, Integer> freqMap = new HashMap<>();
    List<Stack<Integer>> stacks = new ArrayList<>();

    public FreqStack() {
        
    }
    
    public void push(int val) {
        int currFreq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, currFreq);
        if (stacks.size() == currFreq - 1) {
            stacks.add(new Stack<>());
        }
        stacks.get(currFreq - 1).push(val);
    }
    
    public int pop() {
        int maxFreq = stacks.size() - 1;
        int val = stacks.get(maxFreq).pop();
        int currFreq = freqMap.get(val) - 1;

        if (currFreq == 0) {
            freqMap.remove(val);
        } else {
            freqMap.put(val, currFreq);
        }

        if (stacks.get(maxFreq).isEmpty()) {
            stacks.remove(maxFreq);
        }
        
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
