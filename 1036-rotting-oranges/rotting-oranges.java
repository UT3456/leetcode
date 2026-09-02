class Solution {
    public int orangesRotting(int[][] grid) {
        //multisource bfs  
        Queue<int[]>q= new LinkedList<>();
        int cFresh=0;
        //add all the rotten orange
        //in the queue
        int time=0;
        int m=grid.length; int n=grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    //then it is rooten orange
                    q.offer(new int []{i,j});
                }
                if(grid[i][j]==1) cFresh++;//to track if we able to rotte allthe oranges
            }
        }
        if(cFresh==0) return 0;
            int []dr={-1,0,+1,0};
            int dc[]={0,+1,0,-1};
            while(!q.isEmpty())
            {
                int level=q.size();//no of oranges to be processed in this
                while(level-->0)
                {
                    //go to its neighbour
                    int cr=q.peek()[0];
                    int cc=q.peek()[1];
                    q.poll();
                    for(int i=0;i<4;i++)
                    {
                        //check for validity
                        int nr=cr+dr[i];
                        int nc=cc+dc[i];
                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1)
                        {
                            grid[nr][nc]=2; //rottten the orange
                            q.offer(new int []{nr,nc});
                            cFresh--;
                        }
                    }
                }
                time++; //increase the time
            }
             return cFresh==0?time-1:-1;
        }
       
    }
