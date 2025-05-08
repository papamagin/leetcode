//https://leetcode.com/problems/group-anagrams/description/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            res.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
