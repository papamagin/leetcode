//https://leetcode.com/problems/merge-intervals/description/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        List<int[]> resList = new ArrayList<>();
        Arrays.sort(intervals, 0, intervals.length, (i1, i2 ) -> i1[0] - i2[0]);

        int currLeft = intervals[0][0];
        int currRight = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] > currRight) { // new interval
                resList.add(new int[]{currLeft, currRight});
                currLeft = i[0];
                currRight = i[1];
            } else { // same interval but probably extended
                currRight = Math.max(i[1], currRight);
            }

        }

        resList.add(new int[]{currLeft, currRight}); // grab the last one

        return resList.toArray(new int[resList.size()][]);
    }
}
