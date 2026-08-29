class Solution {
    public int candy(int[] ratings) {
        int temp[]=new int [ratings.length];
        temp[0]=1;//assignign the min number of candies that is 1 to 
        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                //give it more than in its left
                temp[i]=temp[i-1]+1;

            }
            else{
                temp[i]=1;
            }
        }
        //now for the right
        for(int i=ratings.length-2;i>=0;i--)
        {
            //now traverse from right to 
            if(ratings[i]>ratings[i+1])
            {
                temp[i]=Math.max(temp[i],temp[i+1]+1);
            }
            
        }
        int ans=0;
        for(int n:temp)
        {
ans+=n;
        }
       return ans; 
    }
}