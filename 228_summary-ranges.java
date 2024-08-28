https://leetcode.com/problems/summary-ranges/description/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        if (nums.length == 1) {
            return List.of(String.valueOf(nums[0]));
        }

        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean isSeq = false;

        for(int i = 0; i < nums.length; i++) {
            // the last element
            if (i == nums.length - 1) {
                appendAndFlush(String.valueOf(nums[i]), res, sb);
                continue;
            }

            // current range is going on
            if (isSeq && nums[i+1] == nums[i] + 1) {
                continue;
            }

            // the last element of current range
            if (isSeq && nums[i+1] > nums[i] + 1) {
                isSeq = false;
                appendAndFlush(String.valueOf(nums[i]), res, sb);
                continue;
            }

            // new one-element range
            if (!isSeq && nums[i+1] > nums[i] + 1) {
                appendAndFlush(String.valueOf(nums[i]), res, sb);
                continue;
            }

            // new multi-element range
            if (!isSeq && nums[i+1] == nums[i] + 1) {
                isSeq = true;
                sb.append(nums[i] + "->");
                continue;
            }
        }

        return res;
    }

    private void appendAndFlush(String s, List<String> res, StringBuilder sb) {
        sb.append(s);
        res.add(sb.toString());
        sb.setLength(0);
    }
}
