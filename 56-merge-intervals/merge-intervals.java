class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev[] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);

            } else {
                ans.add(prev);
                prev = intervals[i];
            }
        }
        ans.add(prev);
        int temp[][] = new int[ans.size()][2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = ans.get(i);
        }
        return temp;
    }
}