class Solution {
    public int lengthOfLongestSubstring(String s) {
     int i=0;
     int j=0;
     Set<Character>set =new HashSet<>();
     int max=0;
     while(j<s.length())
     {
         if(!set.isEmpty() && set.contains(s.charAt(j)))
         {
            //shrink
            while(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;//keep removing unitl it become valid
            }
           

         }
          set.add(s.charAt(j));
         max=Math.max(max,j-i+1);
         j++;
     }  
     return max; 
    }
}