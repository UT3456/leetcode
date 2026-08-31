class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int Min = 100000, i = 1;
        int[] crt = {0, 0};

        ListNode prev = head, curr = head.next, nxt = head.next.next;

        while (nxt != null) {
            if (isCrit(prev, curr, nxt)) {
                if (crt[0] > 0)
                    Min = Math.min(Min, i - crt[Math.min(crt[1], 1)]);
                crt[Math.min(crt[0], 1)] = i;
            }

            prev = curr; curr = nxt;
            nxt = nxt.next;
            i++;
        }

        if (crt[1] == 0) return new int[]{-1, -1};

        return new int[]{Min, crt[1] - crt[0]};
    }
    
    boolean isCrit(ListNode a, ListNode b, ListNode c) {
        return (a.val < b.val && b.val > c.val) ||
               (a.val > b.val && b.val < c.val);
    }

}