class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int ans[]=new int [n-k+1];
      int  map[] =new int[101];
      int i=0;
      int j=0;

      int ind=0;
      while(j<nums.length)
      { map[50+nums[j]]++;
        if(j-i+1==k){
            //find the kth min
           int c=0;
           for(int temp=0;temp<=50.;temp++)
           
           {
             c+=map[temp];
             if(c>=x)
             {
                ans[ind]=temp-50;
                break;
             }
           }
           //remove the i  to form themap 
           map[nums[i]+50]--; i++;
           if(c<x){ans[ind]=0;}
            ind++;
        }
        j++;
       

      }
      return ans;
      
    }
}