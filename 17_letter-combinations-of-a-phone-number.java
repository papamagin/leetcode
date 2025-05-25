//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, List<Character>> phone = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        phone.put('2', List.of('a', 'b', 'c'));
        phone.put('3', List.of('d', 'e', 'f'));
        phone.put('4', List.of('g', 'h', 'i'));
        phone.put('5', List.of('j', 'k', 'l'));
        phone.put('6', List.of('m', 'n', 'o'));
        phone.put('7', List.of('p', 'q', 'r', 's'));
        phone.put('8', List.of('t', 'u', 'v'));
        phone.put('9', List.of('w', 'x', 'y', 'z'));
        backtrack(0, digits, new StringBuilder());
        return res;
    }
    private void backtrack(int pos, String digits, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : phone.get(digits.charAt(pos))) {
            sb.append(c);
            backtrack(pos + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
