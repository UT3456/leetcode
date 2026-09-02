class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        return next(temperatures);
    }
    private int [] next(int arr[])
    {
      int nge[]=new int[arr.length];
      Stack<Integer>st=new Stack<>();
     

      for(int i=arr.length-1;i>=0;i--)
      {
          while(!st.isEmpty() && arr[st.peek()]<=arr[i])
          {
            st.pop();
          }
          nge[i]=st.isEmpty()?0:st.peek()-i;
          st.push(i);
      }
      return nge;
    }
}