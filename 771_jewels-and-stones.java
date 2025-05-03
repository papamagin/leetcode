//https://leetcode.com/problems/jewels-and-stones/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        if (jewels.isEmpty() || stones.isEmpty()) {
            return 0;
        }

        Set<Character> jewelsSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelsSet.add(c);
        }

        int res = 0;
        for (char c : stones.toCharArray()) {
            if (jewelsSet.contains(c)) {
                res++;
            }
        }

        return res;
    }
}
