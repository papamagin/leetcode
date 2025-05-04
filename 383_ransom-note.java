//https://leetcode.com/problems/ransom-note/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (!ransomNote.isEmpty() && magazine.isEmpty()) {
            return false;
        }

        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0)+1);
        }

        for (char c : ransomNote.toCharArray())  {
            if (magazineMap.getOrDefault(c, 0) > 0) {
                magazineMap.put(c, magazineMap.getOrDefault(c, 0)-1);
            } else {
                return false;
            }
        }

        return true;
    }
}
