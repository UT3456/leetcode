class Solution {
    public int maxProfit(int[] prices) {
        int sell=0;
        int buy=prices[0];//i decide to buy at 0th price
        int max=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++)
        {
          max=Math.max(prices[i]-buy,max);
          if(prices[i]<buy)
          {
            buy=prices[i];
          }
        }
        return max<0?0:max;
        
    }
}