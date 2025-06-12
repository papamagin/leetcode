//https://leetcode.com/problems/iterator-for-combination/description

public class CombinationIterator {
    List<String> combinations;
    Iterator<String> iter;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = generateCombinations(characters, combinationLength);
        iter = combinations.iterator();
    }

    public String next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }

    private List<String> generateCombinations(String s, int len) {
        List<String> res = new ArrayList<>();
        backtrack(0, s, len, new StringBuilder(), res);
        // Collections.sort(res);
        return res;
    }

    private void backtrack(int pos, String s, int len, StringBuilder curr, List<String> res) {
        if (curr.length() == len) {
            res.add(curr.toString());
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            curr.append(s.charAt(i));
            backtrack(i + 1, s, len, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
