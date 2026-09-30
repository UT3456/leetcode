class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int maxF = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int map[] = new int[26];
        while (j < s.length()) {
            char ch = s.charAt(j);
            map[ch - 'A']++;
            maxF = Math.max(maxF, map[ch - 'A']);
            if ((j - i + 1) - maxF > k) {
                while ((j - i + 1) - maxF > k) {
                    char temp = s.charAt(i);
                    map[temp - 'A']--;
                    maxF = Math.max(map[temp - 'A'], maxF);
                    i++;
                }
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;

    }
}