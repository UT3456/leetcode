class Solution {
    public String minWindow(String s, String t) {

        int[] map = new int[128];

        // Store frequency of characters required from t
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }

        int i = 0;
        int j = 0;

        int count = 0;              // number of required characters found
        int min = Integer.MAX_VALUE;
        int start = -1;

        while (j < s.length()) {

            char ch = s.charAt(j);

            // If this character is still needed
            if (map[ch] > 0) {
                count++;
            }

            // Add character to current window
            map[ch]--;

            // Current window contains all characters of t
            while (count == t.length()) {

                // Update minimum window
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }

                // Remove s[i] from window
                char left = s.charAt(i);
                map[left]++;

                // If frequency becomes positive,
                // we just removed a required character
                if (map[left] > 0) {
                    count--;
                }

                i++;
            }

            j++;
        }

        // No valid window
        if (start == -1) {
            return "";
        }

        return s.substring(start, start + min);
    }
}